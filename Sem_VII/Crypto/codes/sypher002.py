sbox = [6, 4, 12, 5, 0, 7, 2, 14, 1, 15, 3, 13, 8, 10, 9, 11]

def fun(m0,k0,k1,k2,sbox):
    v0 = sbox[m0^k0]
    x0 = sbox[v0^k1]
    c0 = x0^k2
    print(c0)

def getK2(c0,c1,k2):
    w0 = rbox[c0^k2]
    w1 = rbox[c0^k2]
    return w0,w1

def checkK1(w0,w1,m0,m1):
    v0_list = []
    v1_list = []
    for k1 in range(16):
        v0 = k1^0
        v1 = k1^1
        v0_list.append(v0)
        v1_list.append(v1)

    u0_list = [rbox[v0_list[i]] for i in range(16)]
    u1_list = [rbox[v1_list[i]] for i in range(16)]

    u0_xor_u1 = [u0_list[i]^u1_list[i] for i in range(16)]
    xor = m0^m1

    for i in range(16):
        if(xor==u0_xor_u1[i]):
            print(i)


#       0  1   2  3  4  5  6  7  8   9   10  11  12 13 14 15
sbox = [6, 4, 12, 5, 0, 7, 2, 14, 1, 15, 3, 13, 8, 10, 9, 11]
rbox = [4, 8, 6, 10, 1, 3, 0, 5, 12, 14, 13, 15, 2, 11, 7, 9]

for m in range(16)
    m = int(input())
    print(m fun(m,12,10,2,sbox)
# x0_list = []
# x1_list = []

# for k1 in range(16):
#     x0 = k1^c0
#     x1 = k1^c1
#     x0_list.append(x0)
#     x1_list.append(x1)

# w0_list = [rbox[x0_list[i]] for i in range(16)]
# w1_list = [rbox[x1_list[i]] for i in range(16)]

# m1 = 8 
# v1 = sbox[m1^k0]

# x1 = sbox[v1^k1]


# c1 = sbox[x1^k2]


# c0 = 12 
# c1 = 1 

# x0 = c0^9
# x1 = c1^9


# w0 = rbox[x0] 
# w1 = rbox[x1]

# v0 = w0^9
# v1 = w1^9

# u0 = rbox[v0]
# u1 = rbox[v1]

# m0_list = []
# m1_list = []

# for k0 in range(16):
#     m0 = k0^u0
#     m1 = k0^u1
#     m0_list.append(m0)
#     m1_list.append(m1)

# for i in range(16):
#     if(m1==m1_list[i] and m0==m0_list[i]):
#         print(i)
# u0_list = [rbox[v0_list[i]] for i in range(16)]
# u1_list = [rbox[v1_list[i]] for i in range(16)]

# v0_list = []
# v1_list = []
