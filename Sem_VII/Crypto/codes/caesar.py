alpha_Capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
alpha_small    = "abcdefghijklmnopqrstuvwxyz"

input_string =  "EXXEGOEXSRGI"
# e(x) = (x+k) mod 26
# d(x) = (x-k) mod 26

for i in range(0,26):
    shift = i
    output_string = ""
    for s in input_string:
        x = alpha_Capitals.index(s)
        y = (x-shift) % 26
        output_string += alpha_Capitals[y]
    print(i," ==> ",output_string)    