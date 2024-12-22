package com.hibernate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop{
    @Id
    private int id;
    private String company;

    // @ManyToMany(mappedBy="laptop")
    // private List<Student> student = new ArrayList<>();
    
    // @ManyToMany
    // private List<Student> student = new  ArrayList<>();

    @ManyToOne
    private Student student;


    public Laptop() {}

    public Laptop(String company, int id) {
        this.company = company;
        this.id = id;
    }

    // public Laptop(String company, int id, List<Student> studentList) {
    //     this.company = company;
    //     this.id = id;
    //     this.student = studentList;
    // }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Laptop{");
        sb.append("id=").append(id);
        sb.append(", company=").append(company);
        sb.append('}');
        return sb.toString();
    }

    // public List<Student> getStudent() {
    //     return student;
    // }

    // public void setStudent(List<Student> student) {
    //     this.student = student;
    // }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
}