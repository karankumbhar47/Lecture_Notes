import socket
import argparse

mode = "edit"

def list_files(text):
    lines = text.splitlines()
    print("Select one file for editing ...")
    for i in range(len(lines)):
        print(f"{i+1}. {lines[i]}")
    user_input = int(input())
    return lines[user_input]

def list_options():
    print("a) Edit code \nb) Exit Application")

def code_client(author_name,serverAddress,port):
    global mode
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    server_address = (serverAddress, port)

    client_socket.connect(server_address)

    try:
        client_socket.sendall(author_name.encode('utf-8'))

        while True:
            if(mode=="edit"):
                list_options()
                user_input = input()
                if user_input == "a":
                    # Send the save request to the server
                    client_socket.sendall("files".encode('utf-8'))
                    response = client_socket.recv(1024).decode('utf-8')
                    mode ="files"
                elif user_input == "b":
                    break
            elif(mode=="files"):
                print("=======================")
                file = list_files(response)
                client_socket.sendall(file.encode('utf-8'))
                response = client_socket.recv(1024).decode('utf-8')
                print(response)
                mode ="edit"
            else:
                break
            # else:
            #     # Send the code changes to the server
            #     client_socket.sendall(user_input.encode('utf-8'))

            # Receive and print the response from the server

    finally:
        client_socket.close()

if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='Connect client to main server')
    parser.add_argument('connection', type=str, help='Specify the connection string in the format "userName@serverAddress"')
    parser.add_argument('-p', '--port', type=int, default=22, help='Specify the port number (default is 22)')

    args = parser.parse_args()

    try:
        username, server_address = args.connection.split('@')
    except ValueError:
        print('Error: Invalid connection string. Please use the format "userName@serverAddress"')
    port = args.port
    print(port)
    code_client(username,server_address,args.port)
