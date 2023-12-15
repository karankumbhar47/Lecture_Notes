import argparse
import socket
import sys

def start_server(port):
    server_host = ""

    try:
        server_socket = socket.socket(socket.AF_INET6, socket.SOCK_STREAM)
        server_socket.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server_socket.bind((server_host, port))
        server_socket.listen(1)
        print(f"Server listening on {port} ...")
    except OSError as error:
        print(f"Error Occurred: {error}")
        if server_socket:
            server_socket.close()

    if not server_socket:
        print("Failed to connect \n. Exiting...")
        sys.exit(1)

    while True:
        connection, client_address = server_socket.accept()
        print(f"Accepted connection from {client_address}")

        while True:
            received_data = connection.recv(1024)
            if received_data:
                print(f"Received data from client: {received_data.decode()}")
                connection.sendall(received_data)
            else:
                break
        connection.close()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Start server by giving port number')
    parser.add_argument('-p', '--port', type=int, default=8080, help='Specify the port number (default is 8080)')
    args = parser.parse_args()

    port_number = args.port
    start_server(port_number)
