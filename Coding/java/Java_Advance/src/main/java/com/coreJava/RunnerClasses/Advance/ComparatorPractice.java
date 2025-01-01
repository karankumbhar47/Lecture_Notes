package com.coreJava.RunnerClasses.Advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.models.Student;

public class ComparatorPractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
        ComparatorPractice.main(null);
    }

    public static void main(String arg[]) {
        List<String> stringList = Arrays.asList("Karan", "Kanil", "Kumbhar", "My", "Name");
        stringList.sort((a, b) -> {
            if (a.length() == b.length())
                return a.compareTo(b);
            else
                return a.length() - b.length();
        });

        System.out.println(stringList);

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Karan",12,33));
        studentList.add(null);
        studentList.add(new Student("Prakash",18,39));
        studentList.add(new Student("Aditya",1,30));
        studentList.add(null);
        studentList.add(new Student("Sandesh",10,33));
        studentList.add(new Student("Rahul",22,40));
        studentList.add(null);
        studentList.sort(Comparator.nullsLast(Comparator.comparing(Student::getName).thenComparingInt(x -> x.getRollNumber())));
        // studentList.sort(Comparator.comparing(Student::getName).thenComparing(a -> a.getRollNumber()));


        // studentList.sort(null);
        // Collections.sort(null);
        // System.out.println("roll number asc");
        studentList.forEach(System.out::println);
        // System.out.println("name asc");
        // studentList.sort((a,b) -> a.getName().compareTo(b.getName()));
        // studentList.forEach(System.out::println);
        // studentList.sort((a,b) -> b.getMarks() - a.getMarks());
        // System.out.println("marks dsc");
        // studentList.forEach(System.out::println);


    }

}