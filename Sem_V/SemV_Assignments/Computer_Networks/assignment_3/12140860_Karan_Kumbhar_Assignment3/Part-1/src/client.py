import socket
import os
import argparse
from termcolor import colored

serverName = os.getlogin()  

# Example usage:
def startTerminal(clientUserName,client_socket):
    command_to_run = "pwd"
    client_socket.send(command_to_run.encode('utf-8'))
    dir = client_socket.recv(4096).decode('utf-8')
    while True:
        print(colored(f"{clientUserName}@{serverName}",'blue')+colored(f"{dir}$",'green') ,end=" ")
        command_to_run =  input()
        if command_to_run !="exit":

            client_socket.send(command_to_run.encode('utf-8'))
            output = client_socket.recv(4096).decode('utf-8')

            client_socket.send("pwd".encode('utf-8'))
            dir = client_socket.recv(4096).decode('utf-8')
            
            print(colored(f"{output}",'white'))
        else:
            break

def start_client(port,serverAddress,userName):
    username_input = userName 
    password_input = input("Enter password: ")

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client_socket.connect((serverAddress, port))

    # Authenticate the user
    authentication_credentials = f"{username_input}@{password_input}".encode('utf-8')
    client_socket.send(authentication_credentials)

    authentication_response = client_socket.recv(1024).decode('utf-8')

    if authentication_response.lower() == 'yes':
        print("Authentication successful. Welcome!")
        welcome_message = client_socket.recv(1024).decode('utf-8')
        print(welcome_message)
        startTerminal(username_input,client_socket)

        client_socket.close()
    else:
        print("Authentication failed.")

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Connect client to remote server')
    parser.add_argument('connection', type=str, help='Specify the connection string in the format "userName@serverAddress"')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the port number (default is 22)')

    args = parser.parse_args()
    
    try:
        username, server_address = args.connection.split('@')
    except ValueError:
        print('Error: Invalid connection string. Please use the format "userName@serverAddress"')



    start_client(args.port,server_address,username)

