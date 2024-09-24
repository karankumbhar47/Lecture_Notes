
sbox = {
    0: 15, 1: 14, 2: 11, 3: 12, 4: 6, 5: 13, 6: 7, 7: 8, 8: 0, 9: 3, 10: 9, 11: 10,
    12: 4, 13: 2, 14: 1, 15: 5 
}

def sypher00A(m,k0,k1):
    u = m^k0 
    v = sbox[u] 
    c = k1^v
    return c

# 1, 3
# 3, 6
print(sypher00A(13,8,1))
print(sypher00A(11,8,0))

 


#  k0
# m0 = 10
# m1 = 5

# c0 = 1
# c1 = 7


# list_u0 = [m0 ^ i for i in range(16)]
# list_u1 = [m1 ^ i for i in range(16)]


# # s box

# list_v0 = [sbox[list_u0[i]] for i in range(len(list_u0))]
# list_v1 = [sbox[list_u1[i]] for i in range(len(list_u1))]

# list_v0_xor_v1 = [list_v0[i] ^ list_v1[i] for i in range(len(list_u0))]
# hexAns = [hex(list_v0_xor_v1[i])[-1] for i in range(16)]

# print(list_v0_xor_v1)
# print(hexAns)

# for i in range(16):
#     print(i, ' ==> ', hexAns[i])

# # k1


# # u0 = ko^m0
# # u1 = ko^m1

# list_v0 = [c0 ^ i for i in range(16)]
# list_v1 = [c1 ^ i for i in range(16)]


# # s box
# rsbox = {6: 0, 4: 1, 12: 2, 5: 3, 0: 4, 7: 5, 2: 6, 14: 7,
#          1: 8, 15: 9, 3: 10, 13: 11, 8: 12, 10: 13, 9: 14, 11: 15}


# list_u0 = [rsbox[list_v0[i]] for i in range(len(list_v0))]
# list_u1 = [rsbox[list_v1[i]] for i in range(len(list_v1))]

# list_u0_xor_u1 = [list_u0[i] ^ list_u1[i] for i in range(16)]
# rhexAns = [hex(list_u0_xor_u1[i])[-1] for i in range(16)]
# for i in range(16):
#     print(i, ' ==> ', rhexAns[i])

