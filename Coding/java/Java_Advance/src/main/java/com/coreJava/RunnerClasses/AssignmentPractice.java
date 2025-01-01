package com.coreJava.RunnerClasses;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

class SomeClass implements Cloneable{
    private int id;
    private String Name;

    public SomeClass(int id, String name) {
        this.id = id;
        Name = name;
    }

    @Override
    public SomeClass clone() {
        try {
            SomeClass clone = (SomeClass) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

public class AssignmentPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        SomeClass s1 = new SomeClass(1,"hello");
        SomeClass s2 = new SomeClass(2,"nothing");
        SomeClass s3 = s1;
        SomeClass s4 = s1.clone();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);

        System.out.println(s1==s3);
        System.out.println(s1==s4);

        System.out.println(s1.equals(s3));
        // to equalize, both s1 and s4 need to override
        // equal method and hashcode method
        System.out.println(s1.equals(s4));

    }
}
