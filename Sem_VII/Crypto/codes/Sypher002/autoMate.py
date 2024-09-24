import getPairDict as gp

#       0  1   2  3  4  5  6  7  8   9   10  11  12 13  14 15
sbox = [6, 4, 12, 5, 0, 7, 2, 14, 1, 15, 3,  13, 8, 10, 9, 11]
rbox = [4, 8, 6, 10, 1, 3, 0, 5, 12, 14, 13, 15, 2, 11, 7, 9 ]

dictMiCi = gp.givePair()


list_k0 = []
list_k1 = []
list_k2 = []

mi,ci = gp.getAllFcomb()

def impl(m,k0,k1,k2,sbox):
    v = sbox[m^k0]
    x = sbox[v^k1]
    c = x^k2
    return c

#  r0 <-- |sbox| <-- g0  <== (guess(key))^ p0
#  r1 <-- |sbox| <-- g1  <== (guess(key))^ p1
#  xor = r0^r1
def guessKey(p0,p1,xor,list):
    list_r0 = [rbox[p0^i] for i in range(16)] 
    list_r1 = [rbox[p1^i] for i in range(16)] 

    r0_xor_r1 = [list_r0[i]^list_r1[i] for i in range(16)]

    print("Required xor ==> ",xor)
    for i in range(16):
        if(r0_xor_r1[i]==xor): 
            ans = "match" 
            list.append(i)
        else: ans = "not match"
        print(f"key = {i} , xor = {r0_xor_r1[i]} : {ans}" )

def haveKey(k,p):
    r = rbox[p^k]
    return r


def giveOccur(data):
    occurrences = {i: 0 for i in range(16)}
    for value_list in data.values():
        for number in value_list:
            occurrences[number] += 1
    return occurrences

def giveKeyOrder( occurrences):
    keys_with_values = [key for key, value in occurrences.items() if value > 0]
    sorted_keys = sorted(keys_with_values, key=lambda x: occurrences[x], reverse=True)
    return sorted_keys

def guessKey2():
    diff = 13
    ans = {} 
    for c0,c1 in ci:
        keys = []
        list_w0 = [rbox[i^c0] for i in range(16)]
        list_w1 = [rbox[i^c1] for i in range(16)]
        diff_curr = [list_w0[i]^list_w1[i] for i in range(16)]
        for i in range(16):
            if(diff==diff_curr[i]):
                keys.append(i)
        ans[(c0,c1)] = keys
    orderDict = giveOccur(ans)
    print("k2 --> ")
    print(giveKeyOrder(orderDict))
    return giveKeyOrder(orderDict) 

k2_list = guessKey2()

def guessKey1():
    global k2_list
    print("k1 --> ")
    for k2 in reversed(k2_list):
        ans = {} 
        for _ in range(len(ci)):
            c0,c1 = ci[_]
            m0,m1 = mi[_]
            diff = m0^m1

            w0 = rbox[k2^c0]
            w1 = rbox[k2^c1]
            u0_list = [rbox[k1^w0] for k1 in range(16)]
            u1_list = [rbox[k1^w1] for k1 in range(16)]
            diff_curr = [u0_list[i]^u1_list[i] for i in range(16)]
            keys = []
            for i in range(16):
                if(diff==diff_curr[i]):
                    keys.append(i)
            ans[(c0,c1)] = keys
        orderDict = giveOccur(ans)
        print(f"{k2} ==> {giveKeyOrder(orderDict)}")

    return giveKeyOrder(orderDict)

k1_list = guessKey1()

def guessKeyK0():
    global k1_list
    k2 = k2_list[0]
    print("k0 --> ")
    for k1 in k1_list:
        ans = {}
        for _ in range(len(ci)):
            c0,c1 = ci[_]
            m0,m1 = mi[_]
            w0 = rbox[k2^c0]
            w1 = rbox[k2^c1]
            u0 = rbox[k1^w0]
            u1 = rbox[k1^w1]
            m0i = [u0^k0 for k0 in range(16)]
            m1i = [u1^k0 for k0 in range(16)]

            keys = []
            for i in range(16):
                if(m0==m0i[i] and m1==m1i[i]):
                    keys.append(i)
            ans[(m0,m1)] = keys
        orderDict = giveOccur(ans)
        print(f"{k1} ==> {giveKeyOrder(orderDict)}")
        # return giveKeyOrder(orderDict)

k0_list = guessKeyK0()
print(k0_list)
