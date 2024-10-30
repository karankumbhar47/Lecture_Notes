import subprocess
import ast

# Function to call the AES oracle and get the ciphertext for a given plaintext
def get_ciphertext(plaintext):
    # Convert plaintext list to a command line argument string
    plaintext_str = ' '.join(map(str, plaintext))
    
    # Call the AES oracle (replace './aes' with the correct path to your oracle)
    result = subprocess.run(f'./aes {plaintext_str}', shell=True, capture_output=True, text=True)
    
    # Extract and return the ciphertext list (assuming output is a Python-style list of integers)
    # The 'ast.literal_eval' is used to convert the string output to an actual list
    return ast.literal_eval(result.stdout.strip())

# Function to perform the integral attack
def integral_attack():
    num_variations = 256
    byte_to_vary = 0  # The byte position to vary (can change this as needed)
    
    # Create a list of all ciphertexts for varying one byte of the plaintext
    ciphertexts = []
    
    for i in range(num_variations):
        # Create a base plaintext (all 0's)
        plaintext = [0] * 16
        
        # Vary the byte at the specified position (byte_to_vary)
        plaintext[byte_to_vary] = i
        
        # Get the ciphertext for this plaintext
        ciphertext = get_ciphertext(plaintext)
        
        # Ensure that the ciphertext is a list of 16 bytes
        assert isinstance(ciphertext, list) and len(ciphertext) == 16
        
        # Store the ciphertext in the list
        ciphertexts.append(ciphertext)

    
    # Now check the balanced property for each byte of the ciphertext
    balanced = [0] * 16  # To hold balanced property of each byte
    print(ciphertexts)
    # XOR all the ciphertexts for each byte position to check if they balance
    for ciphertext in ciphertexts:
        for byte_position in range(16):
            balanced[byte_position] ^= ciphertext[byte_position]
    
    # Print the balanced property result
    for byte_position, value in enumerate(balanced):
        if value == 0:
            print(f"Byte {byte_position}: Balanced")
        else:
            print(f"Byte {byte_position}: Not Balanced")

# Run the integral attack
if __name__ == "_main_":
    integral_attack()