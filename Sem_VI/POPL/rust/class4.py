l = [1,2,3]
m = l   #this assign directly the pointer of l to m 
        # now both m, l pointing to same memory location in heap
m[2] = 7;

print(l)
print(m)
