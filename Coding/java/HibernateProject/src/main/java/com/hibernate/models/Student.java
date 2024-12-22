package com.hibernate.models;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public 
class Student{
    @Id
    private int rollNumber;
    private String name;
    private int marks;

    // @OneToMany(mappedBy="student", fetch=FetchType.EAGER)
    // private List<Laptop> laptop= new ArrayList<>();

    // @ManyToMany(mappedBy="student")
    // private List<Laptop> laptop = new ArrayList<>();

    public Student() {}

    public Student(int marks, String name, int rollNumber) {
        this.marks = marks;
        this.name = name;
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

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }



    // public List<Laptop> getLaptop() {
    //     return laptop;
    // }

    // public void setLaptop(List<Laptop> laptop) {
    //     this.laptop = laptop;
    // }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("rollNumber=").append(rollNumber);
        sb.append(", name=").append(name);
        sb.append(", marks=").append(marks);
        // sb.append(", laptop=").append(laptop);
        sb.append('}');
        return sb.toString();
    }

    
}