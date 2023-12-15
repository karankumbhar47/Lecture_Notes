import socket
import argparse


def find_ip_address(domain_name):
    file_path = "../dataset/mappings.txt"
    with open(file_path, "r") as file:
        for line in file:
            domain, ip = line.strip().split()
            if domain == domain_name:
                return True, ip
        return False, -1


def handle_request_DNS(data):
    transaction_id = data[:2]
    domain_name = data[2:].decode("utf-8")
    print(f"Received DNS request for domain: {domain_name}")

    flag, ip = find_ip_address(domain_name)
    if flag:
        response = transaction_id + socket.inet_aton(ip)
        return response
    else:
        return transaction_id + b'\x00\x00\x00\x00'


def start_dns_server(port):
    server_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    server_socket.bind(("127.0.0.1", port))

    print(f"DNS Server is running on port {port}...")

    while True:
        data, client_address = server_socket.recvfrom(1024)
        response = handle_request_DNS(data)
        server_socket.sendto(response, client_address)


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Start server by giving port number')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the port number (default is 22)')
    args = parser.parse_args()

    port = args.port
    start_dns_server(port)
