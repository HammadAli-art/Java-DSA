"""
11 PM Warning Check — runs inside GitHub Actions
------------------------------------------------------
If NOTHING has been solved/pushed yet today (Asia/Karachi day), sends a
warning email. If something already happened today, this does NOTHING —
no email, no Sheet changes. (The 12 AM job handles the final summary.)
"""

import os
import re
import smtplib
import subprocess
from email.mime.text import MIMEText
from datetime import datetime, timezone
from zoneinfo import ZoneInfo

KARACHI = ZoneInfo("Asia/Karachi")
COMMIT_PATTERN = re.compile(r"^(Solve|Resubmit) (\d+)\.\s*(.+)$")

EMAIL_ADDRESS = os.environ["EMAIL_ADDRESS"].strip()
EMAIL_APP_PASSWORD = os.environ["EMAIL_APP_PASSWORD"].strip()
RECIPIENT_EMAIL = os.environ["RECIPIENT_EMAIL"].strip()


def get_today_start_utc():
    now_karachi = datetime.now(KARACHI)
    start_of_day = now_karachi.replace(hour=0, minute=0, second=0, microsecond=0)
    return start_of_day.astimezone(timezone.utc)


def has_any_activity_today():
    since = get_today_start_utc().strftime("%Y-%m-%dT%H:%M:%SZ")
    result = subprocess.run(
        ["git", "log", f"--since={since}", "--pretty=format:%s"],
        capture_output=True, text=True, check=True,
    )
    for line in result.stdout.splitlines():
        if COMMIT_PATTERN.match(line.strip()):
            return True
    return False


def send_email(subject, body):
    msg = MIMEText(body)
    msg["Subject"] = subject
    msg["From"] = EMAIL_ADDRESS
    msg["To"] = RECIPIENT_EMAIL

    with smtplib.SMTP("smtp.gmail.com", 587) as server:
        server.starttls()
        server.login(EMAIL_ADDRESS, EMAIL_APP_PASSWORD)
        server.send_message(msg)


def main():
    if has_any_activity_today():
        print("Activity already found today — no warning needed. Doing nothing.")
        return

    body = (
        "Hi,\n\n"
        "Just a friendly reminder — you have about 1 hour left today, and no "
        "LeetCode problem has been solved or pushed to GitHub yet.\n\n"
        "Even one problem keeps your streak alive. There's still time!\n\n"
        "— Your LeetCode Automation"
    )
    send_email("LeetCode Reminder: 1 Hour Left Today", body)
    print("No activity found today — warning email sent.")


if __name__ == "__main__":
    main()