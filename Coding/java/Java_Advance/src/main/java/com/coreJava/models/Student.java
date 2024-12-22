package com.coreJava.models;

public class Student implements Comparable<Student> {
    private int rollNumber;
    private String name;
    private int marks;

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public Student(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.marks = marks;
        this.rollNumber = rollNumber;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [rollNumber=" + rollNumber + ", name=" + name + ", marks=" + marks + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + rollNumber;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Student other = (Student) obj;
        if (rollNumber != other.rollNumber)
            return false;
        return true;
    }

    // @Override
    // public int compareTo(Student student) {
    // if(student!=null)
    // return this.rollNumber - student.getRollNumber();
    // return -1;

    // }

    @Override
    public int compareTo(Student student) {
        if (student == null) {
            return -1; // This object is considered smaller than null
        }
        return Integer.compare(this.rollNumber, student.getRollNumber());
    }

    // @Override
    // public int compare(Student arg0, Student arg1) {
    // return this.compareTo(arg1);
    // }
}