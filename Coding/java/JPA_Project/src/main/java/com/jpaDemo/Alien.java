package com.jpaDemo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Alien{
    @Id
    private int id;

    private String name;
    private String tech;

    public Alien() {}

    public Alien(int id, String name, String tech) {
        this.id = id;
        this.name = name;
        this.tech = tech;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alien{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", tech=").append(tech);
        sb.append('}');
        return sb.toString();
    }



}
