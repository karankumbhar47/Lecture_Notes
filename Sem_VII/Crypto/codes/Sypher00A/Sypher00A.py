sbox = {
    0: 15, 1: 14, 2: 11, 3: 12, 4: 6, 5: 13, 6: 7, 7: 8, 8: 0, 9: 3, 10: 9, 11: 10,
    12: 4, 13: 2, 14: 1, 15: 5
}


def sypher00A(m, k0, k1):
    u = m ^ k0
    v = sbox[u]
    c = k1 ^ v
    return c


keys0 = [11, 15, 12, 7, 4, 8, 3, 0, 7]
keys1 = [2, 2, 8, 2, 8, 8, 2, 8, 2]

d = {0: 7, 1: 3, 2: 0, 3: 6, 4: 8, 5: 11, 6: 1, 7: 2, 8: 10, 9: 5, 10: 15, 11: 4, 12: 14, 13: 9, 14: 12, 15: 13}

for i in range(len(keys0)):
    flag = True
    for m,c in d.items():
        if sypher00A(m, keys0[i], keys1[i]) != c:
            flag = False
            print(keys0[i],keys1[i]," --> wrong at ",m,c)
            break;
    if(flag):
        print("right key ",keys0[i],keys1[i])
                
