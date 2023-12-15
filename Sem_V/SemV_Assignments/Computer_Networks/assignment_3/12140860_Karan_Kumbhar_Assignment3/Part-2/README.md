# DNS Resolver Application

The DNS Resolver Application translates domain names to IP addresses using socket programming. This enables devices to connect on the internet by converting human-readable names into numerical addresses.
### Dependencies
- Python 3
- argparse module

## Usage

### Running the Server

1. Open a terminal.

2. Navigate to the project directory.

3. Run the following command to start the server:
   ```bash
   python server.py -p <port_number>
   ```
    Replace `<port_number>` with the desired port number. If not specified, the default port is 22.

### Running the Client

1. Open a new terminal.

2. Navigate to the project directory.

3. Run the following command to start the client:
    ```bash
     python client.py -a <server-address> -p <port-number>
    ```
    Replace <port-number> with port number on which server is running
    Replace <server-address> with actual server address of dns server
 
4. Enter the domain name when prompted. To exit, type 'exit'.

### Example
**Server**
```bash
python server.py -p 5555
 ```
### Client

```bash
python client.py -a localhost -p 5555
```

