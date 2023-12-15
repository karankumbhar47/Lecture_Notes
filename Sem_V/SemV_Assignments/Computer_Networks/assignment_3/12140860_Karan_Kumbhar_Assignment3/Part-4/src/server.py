import argparse
import socket
import threading
from datetime import datetime

code_changes = ""
common_file_path = "../dataset/shared_code.txt"

def request_handling(data, username):
    global code_changes
    changes = data.decode("utf-8")
    code_changes += changes
    return "Code Added Successfully".encode("utf-8")

def save_file(username):
    global code_changes

    current_datetime = datetime.now()
    formatted_datetime = current_datetime.strftime("%m-%d-%Y [%I:%M %p]")

    with open(common_file_path, "a") as file:
        file.write(code_changes)
        file.write(f"\n\t\t==> code added by {username} {formatted_datetime}\n")
        code_changes = ""

    return "File saved successfully".encode("utf-8")

def start_client(client_socket, client_address):
    try:
        author = client_socket.recv(1024).decode("utf-8")
        print(f"Authentication name received: {author}")

        while True:
            data = client_socket.recv(1024)
            if not data:
                break

            print(f"Received from {client_address}: {data.decode('utf-8')}")

            if data.decode('utf-8').lower() == "save":
                response = save_file(author)
            else:
                response = request_handling(data, author)

            client_socket.sendall(response)
    finally:
        print(f"Connection with {client_address} closed.")
        client_socket.close()

def start_application_server(port):
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_address = ('127.0.0.1', port)

    server_socket.bind(server_address)
    server_socket.listen(5)

    print(f"Application Server is listening on port {port}...")

    while True:
        connection, client_address = server_socket.accept()
        print(f"Connection from {client_address}")

        client_handler = threading.Thread(target=start_client, args=(connection, client_address))
        client_handler.start()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Start server by giving port number')
    parser.add_argument('-p', '--port', type=int, default=8080, help='Specify the port number (default is 8080)')
    args = parser.parse_args()

    port_number = args.port
    start_application_server(port_number)
