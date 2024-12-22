package com.hibernate.models;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * their are 3 layers  
 * class layer  (Alien)
 * entity layer
 * table layer (table name is derived from entity name)
 * */ 

@Entity
@Table(name="Alien_Table")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Alien{
    @Id
    private int id;

    // @Transient
    private AlienName name;

    @Column(name="alien_color")
    private String color;

    public Alien(){}

    public Alien(String color, int id, AlienName name) {
        this.color = color;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AlienName getName() {
        return name;
    }

    public void setName(AlienName name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alien{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }

}