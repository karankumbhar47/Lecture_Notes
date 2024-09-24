import json
import subprocess
import re

executable = "/home/karan/Sem_VII/Crypto/codes/Sypher00A/00Asypher_8"
pairs = {}

alpha = [9, 10, 13, 3, 1, 4, 8, 14]
beta = [2, 3, 13, 1, 6, 8, 4, 7]

def getXor(num1, num2):
    num = num1 & num2
    result = 0
    while num > 0:
        result ^= (num & 1)
        num >>= 1
    return result


for i in range(16):
    result = subprocess.run([executable], input=str(i),
                            text=True, capture_output=True)
    lines = result.stdout.strip().split('\n')
    if len(lines) == 2:
        message_line = lines[0].strip()
        ciphertext_line = lines[1].strip()

        try:
            message = int(message_line.split()[-1])
            ciphertext = int(ciphertext_line.split()[-1])
            pairs[message] = ciphertext
        except ValueError:
            print(
                f"Failed to parse numbers from lines: {message_line}, {ciphertext_line}")

print(pairs)

list = []
mask_alpha = 13
mask_beta = 13

for mask_alpha in range(16):
    newList = []
    for mask_beta in range(16):
        T0 = 0
        T1 = 0
        for m, c in pairs.items():
            LHS = getXor(mask_alpha & m, mask_beta & c) ^ 1
            if (LHS == 0):
                T0 += 1
            else:
                T1 += 1

        diff = abs(T0-T1)
        if (diff == 16):
            if (T0 > T1):
                print(mask_alpha, mask_beta, " --> T0")
            else:
                print(mask_alpha, mask_beta, " --> T1")
        newList.append(diff)
    list.append(newList)

print(list)
