package com.coreJava.RunnerClasses.basics;

import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.models.Student;

public class ParamPassing implements CodeRunnerInterface {
    /**
     * in java, we always pass the parameter by 'pass by value'
     * 1.  in the case of primitive types, copy of values itself will be passed to function
     * 2.  in case of object copy of reference will be passed to the function
     *     if we change something in that object, it will also reflect in the original
     *     and if we reassign the value(where reference gets changed) -> this changes will not
     *     be reflected in the original object (as it still points to old object)
     */

    @Override
    public void runCode() {
        String a = "Hello World";
        stringFunction(a);
        System.out.println(a);

        Student student = new Student("Karan",1,32);
        changeObject(student);
        System.out.println(student);
    }

    private void stringFunction(String a){
        a += 'c';
        System.out.println(a);
    }

    private void changeObject(Student student){
        student.setName("changedName");
        student = new Student("some other student",121,30);
        System.out.println(student);
    }
}

