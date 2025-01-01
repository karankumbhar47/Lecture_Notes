package com.coreJava.RunnerClasses.basics;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class VariablePractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        double a = 23d;
        do {
            System.out.println(a);
            a--;
        } while (a > 0);

        System.out.println(add(1,2));

        // no constructor class
        // default constructor is available with no args
        NoConstructorClass class1 = new NoConstructorClass();


        // literal and not literal
        // literals are immutable (special memory management for literals)
        // in below example 3 and "Hello" are the literal as their
        // values are taken directly to assign to a variable(literally)
        int  x = 3;
        String s = "Hello";

        // here x is not a literal as we are not taking values
        // instead we are assigning by variable
        int y = x;

    }

    public int add(int a, int b){
        return a+b;
    }
    public double add(double a,double b){
        return a+b;
    }


}

// also default constructor get added
class NoConstructorClass{

}