import argparse
import socket
import sys

def start_client(target_port, target_host):
    address_info = socket.getaddrinfo(target_host, target_port)
    client_socket = None

    for family, socktype, proto, _, sockaddr in address_info:
        try:
            client_socket = socket.socket(family, socktype, proto)
            client_socket.connect(sockaddr)
            break
        except OSError as connection_error:
            print(f"Error Occurred: {connection_error}")
            if client_socket:
                client_socket.close()

    if not client_socket:
        print("Failed to connect \n. Exiting.")
        sys.exit(1)

    print("Connection established")

    while True:
        print("==================================")
        user_input = input("Enter the message \n(or type 'quit' to exit): \n")
        if user_input == "quit":
            break
        client_socket.sendall(user_input.encode())
        received_data = client_socket.recv(1024)
        print(f"Server response: {received_data.decode()}")

    client_socket.close()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Connect client to main server')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the target port number (default is 22)')
    parser.add_argument('-a', '--addr', type=str, default="localhost", help='Specify the target host address (default is localhost)')

    args = parser.parse_args()

    target_port = args.port
    target_host = args.addr

    start_client(target_port, target_host)
