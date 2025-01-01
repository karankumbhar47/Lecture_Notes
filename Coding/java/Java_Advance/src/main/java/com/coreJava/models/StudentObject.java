package com.coreJava.models;

import java.util.Objects;

public class StudentObject {
    private String name;
    private Integer rollNumber;

    public StudentObject(String name, int rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass())
            return false;
        StudentObject that = (StudentObject) o;
        return Objects.equals(rollNumber, that.rollNumber) && Objects.equals(name,
                that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, rollNumber);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{name: " + name + ", rollNumber: " + rollNumber + "}";
    }

}