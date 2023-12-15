# Collaborative Code Editing with Multi-Server Support

## Introduction

This collaborative code editing application allows multiple users to simultaneously edit code on different terminals,
facilitating distributed development and collaboration. This README provides instructions on how to run the
application.

## Prerequisites

- Python 3.x installed on your machine.

## Usage
### `Server`

1. Open a terminal and start the first server:
   ```bash
   python server.py -p <port_number>
   ```
### `Client`

2. Open a new terminal and start the client for the first server:
   ```bash
    python client.py -a localhost -p <port_number>
   ```
   Provide your author name when prompted.

3. Open another terminal and start another client :
    ```bash
    python client.py -a localhost -p <port_number>
    ```
    Again, provide your author name when prompted.

**Collaboration**

  Each client terminal allows users to input code changes or initiate a save operation.
    Code changes are sent to the respective servers, allowing concurrent collaboration.
    Save requests persist changes to the respective shared code files on each server.
