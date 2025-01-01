package com.coreJava.Random;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class ExceptionDemo implements CodeRunnerInterface {
    String str = "a";

    void A() {
        try {
            str += "b";
            B();
        } catch (Exception e) {
            str += "c";
        }
    }

    void B() throws Exception {
        try {
            str += "d";
            C();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            str += "e";
        }

        System.out.println("never goes");
        str += "f";
    }

    void C() throws Exception {
        throw new Exception();
    }

    void display() {
        System.out.println(str);
    }

    private static int someInt;

    public static void main(String[] args) {
        ExceptionDemo object = new ExceptionDemo();
        object.A();
        object.display();

        int a;
        System.out.println(someInt);
        // System.out.println(a);

        // question 2
        // try {
        //     throw new Derived();
        // } catch (Base e) {
        //     System.out.println("Caught base class exception");
        // } catch (Derived d) {
        //     System.out.println("Caught derived class exception");
        // }

    }

    @Override
    public void runCode() {
        ExceptionDemo.main(null);
    }

    // question 2
    class Base extends Exception {
    }

    class Derived extends Base {
    }
}
