# Remote Shell System

This system allows users to remotely connect to a server, authenticate themselves, and execute commands in a shell-like environment.

## Prerequisites

- Python 3.x
- Required Python packages: `psutil`, `termcolor`

Install the required packages using:

```bash
pip install psutil termcolor
```

## Usage

1. **Server Setup**:

    Open a terminal and run the server script:

    ```bash
    python server.py -p <port-number>
    ```

    Replace `<port-number>` with the desired port number.

2. **Client Connection**:

    Open a new terminal and run the client script:
    
    ```bash
    python client.py <username>@<server_address> -p <port>
    ````
    - Replace `<username>` with your username,
    - Replace `<server_address>` with server address(ex. localhost), and 
    - Replace `<port>` with the server port number values.

    Enter the user's password when prompted.

3. **Remote Shell Interaction**:

    - Upon successful authentication, the user will be presented with system information.
    - Enter commands in the client terminal to execute them remotely.

4. **Exiting**:
    - To exit the remote shell, type exit in the client terminal.
