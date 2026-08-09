"""
Daily LeetCode Summary — runs inside GitHub Actions
------------------------------------------------------
1. Finds today's "Solve X. Title" commits (Asia/Karachi day boundary)
2. Sends an email summary (or a warning if nothing was solved today)
3. Logs each solved problem to a Google Sheet, with a clickable GitHub link
"""

import os
import re
import json
import smtplib
import subprocess
from email.mime.text import MIMEText
from datetime import datetime, timezone
from zoneinfo import ZoneInfo
from urllib.parse import quote

import gspread
from google.oauth2.service_account import Credentials

KARACHI = ZoneInfo("Asia/Karachi")
COMMIT_PATTERN = re.compile(r"^Solve (\d+)\.\s*(.+)$")

EMAIL_ADDRESS = os.environ["EMAIL_ADDRESS"].strip()
EMAIL_APP_PASSWORD = os.environ["EMAIL_APP_PASSWORD"].strip()
RECIPIENT_EMAIL = os.environ["RECIPIENT_EMAIL"].strip()
SHEET_ID = os.environ["SHEET_ID"].strip()
GOOGLE_CREDS_JSON = os.environ["GOOGLE_SHEETS_CREDENTIALS"]
REPO = os.environ["GITHUB_REPOSITORY"]  # e.g. "HammadAli-art/Java-DSA"
BRANCH = os.environ.get("GITHUB_REF_NAME", "master")


def get_today_start_utc():
    now_karachi = datetime.now(KARACHI)
    start_of_day = now_karachi.replace(hour=0, minute=0, second=0, microsecond=0)
    return start_of_day.astimezone(timezone.utc)


def get_todays_commits():
    since = get_today_start_utc().strftime("%Y-%m-%dT%H:%M:%SZ")
    result = subprocess.run(
        ["git", "log", f"--since={since}", "--name-only", "--pretty=format:__COMMIT__%H|%s"],
        capture_output=True, text=True, check=True,
    )

    commits = []
    current = None
    for line in result.stdout.splitlines():
        if line.startswith("__COMMIT__"):
            if current:
                commits.append(current)
            _, subject = line.replace("__COMMIT__", "", 1).split("|", 1)
            current = {"subject": subject, "files": []}
        elif line.strip():
            current["files"].append(line.strip())
    if current:
        commits.append(current)

    return commits


def parse_solved_problems(commits):
    problems = []
    for commit in commits:
        match = COMMIT_PATTERN.match(commit["subject"])
        if not match:
            continue

        number, title = match.group(1), match.group(2)

        solution_file = next(
            (f for f in commit["files"] if "LeetCode Problems" in f and not f.endswith("README.md")),
            None,
        )
        if not solution_file:
            continue

        topic_path = solution_file.split("LeetCode Problems/")[-1]
        topic = "/".join(topic_path.split("/")[:-1]) or "Unknown"

        github_url = f"https://github.com/{REPO}/blob/{BRANCH}/{quote(solution_file)}"

        problems.append({
            "number": number,
            "title": title,
            "topic": topic,
            "url": github_url,
        })
    return problems


def send_email(subject, body):
    msg = MIMEText(body)
    msg["Subject"] = subject
    msg["From"] = EMAIL_ADDRESS
    msg["To"] = RECIPIENT_EMAIL

    with smtplib.SMTP("smtp.gmail.com", 587) as server:
        server.starttls()
        server.login(EMAIL_ADDRESS, EMAIL_APP_PASSWORD)
        server.send_message(msg)


def log_to_sheet(problems):
    creds_info = json.loads(GOOGLE_CREDS_JSON)
    scopes = ["https://www.googleapis.com/auth/spreadsheets"]
    creds = Credentials.from_service_account_info(creds_info, scopes=scopes)
    client = gspread.authorize(creds)
    sheet = client.open_by_key(SHEET_ID).sheet1

    today_str = datetime.now(KARACHI).strftime("%Y-%m-%d")
    day_str = datetime.now(KARACHI).strftime("%A")

    rows = []
    for p in problems:
        link_formula = f'=HYPERLINK("{p["url"]}", "{p["title"]}")'
        rows.append([today_str, day_str, p["number"], link_formula, p["topic"]])

    sheet.append_rows(rows, value_input_option="USER_ENTERED")


def main():
    commits = get_todays_commits()
    problems = parse_solved_problems(commits)

    if problems:
        lines = [f"You solved {len(problems)} problem(s) today:\n"]
        for p in problems:
            lines.append(f"- {p['number']}. {p['title']}  ({p['topic']})")
        body = "\n".join(lines)

        send_email(f"LeetCode: {len(problems)} problem(s) solved today", body)
        log_to_sheet(problems)
        print(f"Logged and emailed {len(problems)} problems.")
    else:
        send_email(
            "LeetCode: No contribution today",
            "You have about 1 hour left today and no LeetCode problem has "
            "been pushed to GitHub yet. Don't break the streak!",
        )
        print("No problems solved today — warning email sent.")


if __name__ == "__main__":
    main()