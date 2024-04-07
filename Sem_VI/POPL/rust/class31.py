#by default all vars are public in python class

class BaseTest:
    baseVar = "base"

class Test(BaseTest):
    i = "world"
    __i = "this is private"
    __j_ = "this is also var"

    def __init__(self):
        print("this is constructor with no destructor")
        print("because of garbage collector")
        i = "different i not class variable but local"

    def printTest(self):
        print("hello "+self.i)

    def printTest(self,s):
        print("hello "+s)

    def getI(self):
        print(self.__i)

        

t = Test()
t.x = 1234
t.printTest("karan")
t.printTest("nothing")
t.printTest(t.i)
print(t.baseVar)
print(t.x)
t.getI()
print(t.__i)
print(t.__j_)
