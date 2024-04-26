class D:
    def __init__(self):
        print("super class d called")

    def show(self):
        print("class d called")



class B(D):
    def __init__(self):
        print("class b called")

    def show(self):
        print("class b called")


class A(D):
    def __init__(self):
        print("class a called")

    def show(self):
        print("class a called")


class C(A, B):
    pass


c = C()
c.show()
