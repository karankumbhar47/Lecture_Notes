import socket
import subprocess
import os
import psutil
from datetime import datetime
from command import run_command
from loginUser import authenticate_user,update_last_login
import argparse

def validate_credentials(username, password):
    if(authenticate_user(username,password)==None):
        return False,-1
    else:
        if(authenticate_user(username,password)==-1):
            return True,-1 
        else:
            return True,authenticate_user(username,password)


def retrieve_system_information(username,time):
    memory_usage = psutil.virtual_memory().percent
    process_count = len(psutil.pids())
    ipv4_address = socket.gethostbyname(socket.gethostname())
    last_login_time = datetime.now().strftime('%a %d-%m-%y')
    
    deviceName = hostname = os.uname().nodename
    update_last_login(username,last_login_time)
    
    if(time!=-1):
        formatted_text = f"Welcome to {deviceName} \n\n" \
                        f"System information:\n" \
                        f"Memory usage: {memory_usage}%\n" \
                        f"Processes: {process_count}\n" \
                        f"IPv4 address: {ipv4_address}\n" \
                        f"Last login: {time}"
    else:
        formatted_text = f"Welcome to {deviceName} \n\n" \
                        f"System information:\n" \
                        f"Memory usage: {memory_usage}%\n" \
                        f"Processes: {process_count}\n" \
                        f"IPv4 address: {ipv4_address}\n" \
                        f"Last login: {last_login_time}"

    return formatted_text


def start_server(port):
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_socket.bind(('localhost', port))
    server_socket.listen(1)
    print(f"Server listening on port {port}")

    while True:
        connection_socket, client_address = server_socket.accept()
        print(f"Connection from {client_address}")

        received_data = connection_socket.recv(1024).decode('utf-8').strip().split('@')
        flag, time = validate_credentials(received_data[0], received_data[1])
        if len(received_data) == 2 and flag:
            connection_socket.send(b'yes')
            welcome_message = retrieve_system_information(received_data[0],time)
            # connection_socket.send
            connection_socket.send(welcome_message.encode('utf-8'))

            while True:
                received_command = connection_socket.recv(1024).decode('utf-8')
                if(received_command!="exit"):
                    dir,response =run_command(received_command)
                    connection_socket.send(response.encode('utf-8'))
                else:
                    break

            connection_socket.close()
            print("Connection closed")
        else:
            connection_socket.send(b'no')
            connection_socket.close()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Start server by giving port number')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the port number (default is 22)')
    args = parser.parse_args()

    port = args.port 
    start_server(port)

