#!/bin/bash

# Define file names
KEY_FILE="mykey.pem"
CERT_FILE="mycert.pem"
CSR_FILE="mycsr.csr"

# Step 1: Generate Private Key
echo "Generating private key..."
openssl genpkey -algorithm RSA -out $KEY_FILE -aes256
if [ $? -ne 0 ]; then
  echo "Failed to generate private key."
  exit 1
fi

# Step 2: Generate CSR
echo "Generating CSR..."
openssl req -new -key $KEY_FILE -out $CSR_FILE
if [ $? -ne 0 ]; then
  echo "Failed to generate CSR."
  exit 1
fi

# Step 3: Generate Self-Signed Certificate
echo "Generating self-signed certificate..."
openssl x509 -req -days 365 -in $CSR_FILE -signkey $KEY_FILE -out $CERT_FILE
if [ $? -ne 0 ]; then
  echo "Failed to generate certificate."
  exit 1
fi

# Function to run server in a new terminal with a specific title
run_server() {
  PROTOCOL=$1
  PORT=$2

  echo "Starting $PROTOCOL server on port $PORT..."
  gnome-terminal --title="$PROTOCOL Server" -- bash -c "openssl s_server -cert $CERT_FILE -key $KEY_FILE -accept $PORT -$PROTOCOL; exec bash"
}

# Function to run client in a new terminal with a specific title
run_client() {
  PROTOCOL=$1
  PORT=$2

  echo "Starting $PROTOCOL client to connect to port $PORT..."
  gnome-terminal --title="$PROTOCOL Client" -- bash -c "openssl s_client -connect localhost:$PORT -$PROTOCOL; exec bash"
}

# Step 4: Run servers and clients for TLS 1.2 and TLS 1.3

# Run TLS 1.2 server and client
run_server "tls1_2" 4443
echo "Waiting for TLS 1.2 server to start and prompt for password..."
sleep 10 # Adjust this time if needed
run_client "tls1_2" 4443

# Run TLS 1.3 server and client
run_server "tls1_3" 4444
echo "Waiting for TLS 1.3 server to start and prompt for password..."
sleep 10 # Adjust this time if needed
run_client "tls1_3" 4444

echo "All commands have been executed in separate terminals."
