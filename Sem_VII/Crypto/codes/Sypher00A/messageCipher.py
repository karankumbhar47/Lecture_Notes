import subprocess

def getMessageCipherPairWithDiff(binaryPath):
    messages = []
    ciphers = []

    for m0 in range(16):
        messages.append(m0)
        m0 = f'{m0}\n'.encode('utf-8')
        result = subprocess.run([binaryPath], input=m0, capture_output=True)
        output = result.stdout.decode('utf-8').strip()
        lines = output.splitlines()
        ciphertext_line = next(line for line in lines if "Ciphertext:" in line)
        ciphertext_value = int(ciphertext_line.split(":")[1].strip())
        ciphers.append(ciphertext_value)

    return messages, ciphers