#include <iostream>

class Parent {
public:
    // Default constructor
    Parent() {
        std::cout << "Parent default constructor" << std::endl;
    }

    // Parameterized constructor
    Parent(int x) {
        std::cout << "Parent parameterized constructor with " << x << std::endl;
    }
};

class Child : public Parent {
public:
    // Default constructor
    Child() : Parent() {
        std::cout << "Child default constructor" << std::endl;
    }

    // Parameterized constructor
    Child(int x, int y) : Parent(x) {
        std::cout << "Child parameterized constructor with " << y << std::endl;
    }
};

int main() {
    // Create objects using different constructors
    Child c1;             // Calls Parent default constructor, then Child default constructor
    Child c2(20, 30);     // Calls Parent parameterized constructor with 20, then Child parameterized constructor with 30
    
    return 0;
}
