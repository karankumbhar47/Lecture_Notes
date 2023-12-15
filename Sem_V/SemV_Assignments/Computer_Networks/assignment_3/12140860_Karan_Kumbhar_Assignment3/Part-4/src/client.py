import argparse
import socket

def start_client(port, address):
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_address = (address, port)

    client_socket.connect(server_address)

    try:
        author = input("Please mention your author name : ")
        client_socket.sendall(author.encode('utf-8'))

        while True:
            print("=================================")
            user_input = input("Enter code changes \nor save the file by typing 'save':\n \n")

            if user_input.lower() == "save":
                client_socket.sendall("save".encode('utf-8'))
            else:
                client_socket.sendall(user_input.encode('utf-8'))

            response = client_socket.recv(1024).decode('utf-8')
            print(response)
    finally:
        client_socket.close()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Connect client to main server')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the target port number (default is 22)')
    parser.add_argument('-a', '--addr', type=str, default="localhost", help='Specify the target host address (default is localhost)')

    args = parser.parse_args()

    target_port = args.port
    target_host = args.addr

    start_client(target_port, target_host)