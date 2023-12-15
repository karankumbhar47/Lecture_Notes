import socket
import random
import argparse

def sendDNSRequest(serverAddress,port):
    transaction_id_int = random.randint(0, 65535)
    transaction_id_bytes = transaction_id_int.to_bytes(2, byteorder='big')
    transaction_id = transaction_id_bytes

    client_socket = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

    while True:
        domain_name = input("Enter the Domain Name \n(e.g., www.yahoo.com): ")
        if domain_name.lower() == 'exit':
            break

        request = transaction_id + domain_name.encode("utf-8")
        client_socket.sendto(request, (serverAddress, port))

        data, _ = client_socket.recvfrom(1024)
        received_transaction_id = data[:2]

        if received_transaction_id == transaction_id:
            ip_address = socket.inet_ntoa(data[2:])
            if(ip_address=="0.0.0.0"):
                print("======================================")
                print(f"Transaction id ==> {transaction_id_int}\nIp address not found\n")
                print("======================================")
            else:
                print("======================================")
                print(f"Transaction id ==> {transaction_id_int}\nIP Address for {domain_name}: {ip_address}\n")
                print("======================================")
        else:
            print("Error: Transaction ID mismatch. Discarding response.")


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Connect client to dns server')
    parser.add_argument('-a', '--addr', type=str, default="localhost", help='Specify the address of dns server (default is localhost)')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the port number (default is 22)')

    args = parser.parse_args()

    sendDNSRequest(args.addr,args.port)
