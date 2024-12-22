import math

def findSum(level, child):
    if level==0:
        return 1
    else:
        power = math.pow(2,level)
        num = power+child-1
        diff = num-power+1
        child = math.ceil(diff/2)
        return findSum(level-1,child)+num;

for _ in range(int(input())):
    n=int(input())
    if(n<1)
    level = math.floor(math.log(n,2))
    child = n-pow(2,level)+1
    print(int(findSum(level,child)))

