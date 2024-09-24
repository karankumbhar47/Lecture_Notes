def givePair():
    with open('out.txt', 'r') as file:
        lines = file.readlines()

    message_cipher_dict = {}
    for i in range(0, len(lines), 2):
        message = int(lines[i].split('Message: ')[1].strip())
        ciphertext = int(lines[i+1].split('Ciphertext: ')[1].strip())
        message_cipher_dict[message] = ciphertext

    return message_cipher_dict


def getAllFcomb():
    dictMiCi = givePair()
    mi = []
    ci = []
    for key1 in dictMiCi.keys():
        for key2 in dictMiCi.keys():
            if(key1^key2==15):
                mi.append((key1,key2))
                ci.append((dictMiCi[key1],dictMiCi[key2]))
    return mi,ci
