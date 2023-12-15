import argparse
import socket
import subprocess
import threading
import os
from list_files import listFiles, filePath
from edit_file import edit_file_with_vim

# Shared code content
shared_code = ""
shared_file_path = "dataset/file1.txt"
files_path = "../dataset"


# def handle_code_request(data, auth_name):
#     global shared_code
#     # Extracting the code changes from the request
#     code_changes = data.decode("utf-8")
#
#     # Apply the code changes to the shared code
#     shared_code += f"{auth_name}: {code_changes}\n"
#
#     return "Code changes applied successfully".encode("utf-8")
#
# def handle_save_request():
#     global shared_code
#     # Save the current shared code to the file
#     with open(shared_file_path, "a") as file:
#         file.write(shared_code)
#         shared_code = ""  # Clear shared_code after saving
#
#     return "File saved successfully".encode("utf-8")

def handle_client(client_socket, client_address):
    try:
        # Get the user's authentication name
        author_name = client_socket.recv(1024).decode("utf-8")
        print(f"Authentication name received: {author_name}")

        while True:
            # Receive data from the client (code changes or save request)
            print("while")
            data = client_socket.recv(1024)
            if not data:
                break

            print(f"Received from {client_address}: {data.decode('utf-8')}")

            if data.decode('utf-8').lower() == "files":
                # Handle the save request
                response = listFiles().encode('utf-8')
            else:
                try:
                    file = filePath(data.decode('utf-8'))
                    if (file != -1):
                        flag = edit_file_with_vim(file, author_name)
                        if flag:
                            response = "Code saved Successfully".encode('utf-8')
                        else:
                            response = "Code Not Saved".encode('utf-8')
                    else:
                        response = "File Not Found".encode('utf-8')
                except:
                    response = "Error occurs!".encode('utf-8')

            client_socket.sendall(response)

    finally:
        print(f"Connection with {client_address} closed.")
        client_socket.close()


def start_code_server(port):
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_address = ('127.0.0.1', port)

    server_socket.bind(server_address)
    server_socket.listen(5)

    print("Application Server is listening for incoming connections...")

    while True:
        connection, client_address = server_socket.accept()
        print(f"Connection from {client_address}")

        # Start a new thread to handle the client
        client_handler = threading.Thread(target=handle_client, args=(connection, client_address))
        client_handler.start()


if __name__ == "__main__":
    # Create a directory to store uploaded files
    if not os.path.exists(files_path):
        os.makedirs(files_path)

    parser = argparse.ArgumentParser(description='Start server by giving port number')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the port number (default is 22)')
    args = parser.parse_args()

    port = args.port
    start_code_server(port)
