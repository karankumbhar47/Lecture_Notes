# Echo Client/Server Protocol Independence

This repository contains Python scripts, `client.py` and `server.py`, implementing an echo client-server system with support for both IPv4 and IPv6. The code utilizes the `socket` library and `getaddrinfo` to enable communication over different network protocols.

## Dependencies
- Python 3.x

## Usages

### `client.py`

1. Open a terminal.
2. Navigate to the directory containing `client.py`.
3. Run the following command, replacing `<port_number>` and `<target_host>` with the desired port and host:

    ```bash
    python client.py -p <port_number> -a <target_host>
    ```

4. Follow the on-screen instructions to enter messages. Type 'quit' to exit.

### `server.py`

1. Open a separate terminal.
2. Navigate to the directory containing `server.py`.
3. Run the following command, replacing `<port_number>` with the desired port:

    ```bash
    python server.py -p <port_number>
    ```

4. The server will start listening on the specified port.

## Example

1. Open a terminal and start the server:

    ```bash
    python server.py -p 8080
    ```

2. Open another terminal and start the client:

    ```bash
    python client.py -p 8080 -a localhost
    ```

3. Enter messages in the client terminal to see them echoed by the server.


