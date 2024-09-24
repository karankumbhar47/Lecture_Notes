def xor(num):
    result = 0
    while num > 0:
        result ^= (num & 1)
        num >>= 1
    return result


while(True):
    x = int(input())
    y = int(input())
    print(xor(x&y))
