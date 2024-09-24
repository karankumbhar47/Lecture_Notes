import subprocess
import random

sbox = [15, 14, 11, 12, 6, 13, 7, 8, 0, 3, 9, 10, 4, 2, 1, 5]


def matrix_mulitply(num1, num2):
    num = num1 & num2
    result = 0
    while num > 0:
        result ^= (num & 1)
        num >>= 1
    return result


ans = [[0 for i in range(16)]for j in range(16)]


def lat():
    for x in range(1, 16):
        for y in range(1, 16):
            count = 0
            for z in range(16):
                alpha_x = matrix_mulitply(x, z)
                beta_x = matrix_mulitply(y, sbox[z])
                if alpha_x == beta_x:
                    count += 1
            ans[x][y] = count - 8
    alpha = []
    beta = []
    for i in range(1, 16):
        for j in range(1, 16):
            if ans[i][j] != 0 and abs(ans[i][j]) != 2:
                alpha.append(i)
                beta.append(j)
    return alpha, beta


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


_, ciphers = getMessageCipherPairWithDiff(
    '/home/karan/Sem_VII/Crypto/codes/Sypher00A/00Asypher_8')

alpha, beta = lat()


T1 = 0
T0 = 0


def solver(LHS, alpha, beta):
    key_space = [(i, j) for i in range(1, 16) for j in range(1, 16)]
    newKeySpace = []

    for idx in range(len(alpha)):
        print(idx)
        print(len(key_space))
        for k0, k1 in key_space:
            alpha_k0 = matrix_mulitply(alpha[idx], k0)
            beta_k1 = matrix_mulitply(beta[idx], k1)
            if alpha_k0 ^ beta_k1 == LHS[idx]:
                newKeySpace.append((k0, k1))
        print(idx, key_space)
        key_space = newKeySpace


T1_list = []
T0_list = []
LHS = []
for idx in range(len(alpha)):
    T1 = 0
    T0 = 0
    for i in range(16):
        alpha_x = matrix_mulitply(alpha[idx], i)
        beta_sx = matrix_mulitply(beta[idx], ciphers[i])
        print(alpha_x^beta_sx)
        if (alpha_x ^ beta_sx) == 1:
            T1 += 1
        else:
            T0 += 1
    if (T1 > T0):
        LHS.append(1)
    else:
        LHS.append(0)

    T1_list.append(T1)
    T0_list.append(T0)


print(alpha)
print(beta)
print(T0_list)
print(T1_list)
print(LHS)

# solver(LHS, alpha, beta)
