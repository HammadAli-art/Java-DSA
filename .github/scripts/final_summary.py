"""
Summarizes the PAST calendar day (Asia/Karachi). If anything was solved or
resubmitted:

- Sends a professional summary email
- Adds new rows to the Google Sheet for first-time solves
- UPDATES the existing row for resubmitted problems (in place)

If nothing happened that day:
- Sends a "no submission" email
- Does NOT touch the Google Sheet
"""

import os
import re
import json
import smtplib
import subprocess
from email.mime.text import MIMEText
from datetime import datetime, timedelta, timezone
from zoneinfo import ZoneInfo
from urllib.parse import quote

import gspread
from google.oauth2.service_account import Credentials


KARACHI = ZoneInfo("Asia/Karachi")

COMMIT_PATTERN = re.compile(r"^(Solve|Resubmit) (\d+)\.\s*\*(.+)\*$")

EMAIL_ADDRESS = os.environ["EMAIL_ADDRESS"].strip()
EMAIL_APP_PASSWORD = os.environ["EMAIL_APP_PASSWORD"].strip()
RECIPIENT_EMAIL = os.environ["RECIPIENT_EMAIL"].strip()
SHEET_ID = os.environ["SHEET_ID"].strip()
GOOGLE_CREDS_JSON = os.environ["GOOGLE_SHEETS_CREDENTIALS"]
REPO = os.environ["GITHUB_REPOSITORY"]
BRANCH = os.environ.get("GITHUB_REF_NAME", "master")

PROBLEMS_SUBDIR = "LeetCode Problems"


def get_yesterday_range_utc():
    """
    This job runs right at the PKT day boundary (~00:00 PKT).

    We want to summarize the day that JUST ENDED, so we compute the
    full previous Karachi calendar day and convert that range to UTC
    for git log.
    """
    now_karachi = datetime.now(KARACHI)

    today_start = now_karachi.replace(
        hour=0,
        minute=0,
        second=0,
        microsecond=0
    )

    yesterday_start = today_start - timedelta(days=1)

    return (
        yesterday_start.astimezone(timezone.utc),
        today_start.astimezone(timezone.utc)
    )


def get_days_commits():
    since_utc, until_utc = get_yesterday_range_utc()

    since_str = since_utc.strftime("%Y-%m-%dT%H:%M:%SZ")
    until_str = until_utc.strftime("%Y-%m-%dT%H:%M:%SZ")

    result = subprocess.run(
        [
            "git",
            "log",
            f"--since={since_str}",
            f"--until={until_str}",
            "--name-status",
            "--pretty=format:__COMMIT__%H|%s",
        ],
        capture_output=True,
        text=True,
        check=True,
    )

    commits = []
    current = None

    for line in result.stdout.splitlines():

        if line.startswith("__COMMIT__"):

            if current:
                commits.append(current)

            _, subject = line.replace(
                "__COMMIT__",
                "",
                1
            ).split("|", 1)

            current = {
                "subject": subject,
                "files": []
            }

        elif line.strip():

            # Format:
            # A    path
            # M    path
            # D    path

            parts = line.split("\t", 1)

            if len(parts) == 2:

                status, path = parts

                # Only keep Added/Modified files.
                # Deleted files are skipped because for a resubmission
                # we want the file that still exists.
                if status.strip().startswith(("A", "M")):
                    current["files"].append(path.strip())

    if current:
        commits.append(current)

    return commits


def parse_problems(commits):
    """
    Returns a dict keyed by problem number.

    Git log lists commits newest-first, so the first matching commit
    for a problem is the latest state for that problem on that day.
    """

    problems = {}

    for commit in commits:

        match = COMMIT_PATTERN.match(commit["subject"])

        if not match:
            continue

        action, number, title = match.groups()

        # Already processed this problem today.
        if number in problems:
            continue

        solution_file = next(
            (
                f
                for f in commit["files"]
                if PROBLEMS_SUBDIR in f
                and not f.endswith("README.md")
            ),
            None,
        )

        if not solution_file:
            continue

        topic = (
            solution_file
            .split(f"{PROBLEMS_SUBDIR}/")[-1]
            .split("/")[0]
        )

        github_url = (
            f"https://github.com/{REPO}/blob/{BRANCH}/"
            f"{quote(solution_file)}"
        )

        problems[number] = {
            "number": number,
            "title": title,
            "topic": topic,
            "url": github_url,
            "action": action,
        }

    return list(problems.values())


def send_email(subject, body):
    msg = MIMEText(body)

    msg["Subject"] = subject
    msg["From"] = EMAIL_ADDRESS
    msg["To"] = RECIPIENT_EMAIL

    with smtplib.SMTP("smtp.gmail.com", 587) as server:
        server.starttls()
        server.login(
            EMAIL_ADDRESS,
            EMAIL_APP_PASSWORD
        )
        server.send_message(msg)


def get_sheet():
    creds_info = json.loads(GOOGLE_CREDS_JSON)

    scopes = [
        "https://www.googleapis.com/auth/spreadsheets"
    ]

    creds = Credentials.from_service_account_info(
        creds_info,
        scopes=scopes
    )

    client = gspread.authorize(creds)

    return client.open_by_key(SHEET_ID).sheet1


def upsert_problems_to_sheet(problems):
    sheet = get_sheet()

    number_column = sheet.col_values(3)

    # IMPORTANT:
    # The problems being summarized belong to YESTERDAY,
    # so the Sheet must also use YESTERDAY'S date/day.
    now_karachi = datetime.now(KARACHI)

    today_start = now_karachi.replace(
        hour=0,
        minute=0,
        second=0,
        microsecond=0
    )

    yesterday = today_start - timedelta(days=1)

    date_str = yesterday.strftime("%Y-%m-%d")
    day_str = yesterday.strftime("%A")

    rows_to_append = []

    for p in problems:

        link_formula = (
            f'=HYPERLINK("{p["url"]}", "{p["title"]}")'
        )

        row_values = [
            date_str,
            day_str,
            p["number"],
            link_formula,
            p["topic"],
        ]

        existing_row_index = None

        for i, value in enumerate(number_column, start=1):

            if value.strip() == p["number"]:
                existing_row_index = i
                break

        if existing_row_index:

            sheet.update(
                f"A{existing_row_index}:E{existing_row_index}",
                [row_values],
                value_input_option="USER_ENTERED",
            )

            print(
                f"  Updated existing row for "
                f"{p['number']}. {p['title']}"
            )

        else:

            rows_to_append.append(row_values)

    if rows_to_append:

        sheet.append_rows(
            rows_to_append,
            value_input_option="USER_ENTERED"
        )

        print(
            f"  Appended {len(rows_to_append)} new row(s)."
        )


def build_summary_email(problems):

    solves = [
        p for p in problems
        if p["action"] == "Solve"
    ]

    resubmits = [
        p for p in problems
        if p["action"] == "Resubmit"
    ]

    lines = ["Hi,\n"]

    lines.append(
        f"Here's your LeetCode summary for today — "
        f"{len(problems)} problem(s) touched:\n"
    )

    for p in problems:

        tag = (
            " (resubmitted with an updated solution)"
            if p["action"] == "Resubmit"
            else ""
        )

        lines.append(
            f"- {p['number']}. {p['title']} — "
            f"{p['topic']}{tag}"
        )

    lines.append(
        "\nGreat consistency today — keep the streak going!\n"
    )

    lines.append(
        "— Your LeetCode Automation"
    )

    if resubmits:

        subject = (
            f"LeetCode: {len(solves)} solved, "
            f"{len(resubmits)} updated today"
        )

    else:

        subject = (
            f"LeetCode: "
            f"{len(solves)} problem(s) solved today"
        )

    return subject, "\n".join(lines)


def main():

    commits = get_days_commits()

    problems = parse_problems(commits)

    if problems:

        subject, body = build_summary_email(problems)

        send_email(
            subject,
            body
        )

        upsert_problems_to_sheet(problems)

        print(
            f"Emailed and logged "
            f"{len(problems)} problem(s)."
        )

    else:

        body = (
            "Hi,\n\n"
            "No LeetCode problems were solved or pushed "
            "to GitHub today. "
            "Your tracking sheet has not been changed.\n\n"
            "Tomorrow's a fresh start — good luck!\n\n"
            "— Your LeetCode Automation"
        )

        send_email(
            "LeetCode: No Submission Today",
            body
        )

        print(
            "No activity today — "
            "'no submission' email sent, Sheet untouched."
        )


if __name__ == "__main__":
    main()