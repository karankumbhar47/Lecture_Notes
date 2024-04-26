l = [1,2,3]
m = l   #this assign directly the pointer of l to m 
        # now both m, l pointing to same memory location in heap
m[2] = 7;

print(l)
print(m)


global x
x = 0
def f1():
    # global x;
    x = 5
    f2()

def f2():
    print(x)



f1()

