package com.coreJava.Random;

import java.util.Optional;
import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.Random.MyOuter.MyInner;

class MiniSuperClass {
    public void leg() {
        Optional<Integer> op = Optional.ofNullable(4);
        op.ifPresentOrElse(arg0 -> {
            System.out.println("Value is not null " + arg0);
        }, () -> {
            System.out.println("Value is null and so running another action");
        });
        System.out.println("I have super legs");
    }
}

interface Animal {
    public default void leg() {
        System.out.println("I have four legs");
    }

    private static void nothing() {
        System.out.println("Some random method");
    }

    public static void main() {
        System.out.println("This is main method");
        nothing();
    }
}

interface Human {
    default void leg() {
        System.out.println("I have two legs");
    }
}

public class SubClass extends MiniSuperClass implements Animal, Human, CodeRunnerInterface {

    @Override
    public void runCode() {
        Animal.main();
        leg();
    }

    @Override
    public void leg() {
        super.leg();
        Animal.super.leg();
        Human.super.leg();

        char c1 = 016777;
        char c3 = 0xbeef;
        char c4 = 0b10001;
        char c5 = 0xface;
        char c6 = '\uface';
        System.out.println(c5 == c6);
        System.err.println(c1 + " " + c3 + " " + c6);
        int d = (int) 1e9 + 7; // 1200.0
        System.out.println(d);
    }

    protected void fun() {
        leg();
        float f1 = -343;
        // float f2 = 3.14;
        float f3 = 0x12345;
        // float f4 = 42e7;
        // float f5 = 2001.0D;
        float f6 = 2.81F;
        // String s4 = (String) '\ufeed';

    }

}
