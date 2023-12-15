import csv
import hashlib
from getpass import getpass
from datetime import datetime

USER_FILE = "../dataset/user_data.csv"

def authenticate_user(username, password):
    user_data = load_user_data()

    if username in user_data:
        if password == user_data[username]['password']:
            last_login_time = user_data[username]['last_login']
            return last_login_time if last_login_time else -1
    return None

def load_user_data():
    try:
        with open(USER_FILE, 'r', newline='') as file:
            reader = csv.DictReader(file)
            user_data = {row['userName']: {'password': row['password'], 'last_login': row['last-login-time']} for row in reader}
    except FileNotFoundError:
        user_data = {}
    return user_data

def update_last_login(username, last_login_time):
    user_data = load_user_data()

    if username in user_data:
        user_data[username]['last_login'] = last_login_time
        save_user_data(user_data)
        return True
    return False

def save_user_data(user_data):
    with open(USER_FILE, 'w', newline='') as file:
        fieldnames = ['userName', 'password', 'last-login-time']
        writer = csv.DictWriter(file, fieldnames=fieldnames)

        writer.writeheader()
        for username, data in user_data.items():
            writer.writerow({'userName': username, 'password': data['password'], 'last-login-time': data['last_login']})
