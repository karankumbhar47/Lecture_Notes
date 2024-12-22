package com.jpaDemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main{
    public static void main(String args[]){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu");
        EntityManager manager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        // Alien alien1 = new Alien(1,"alien","java");
        // manager.persist(alien1);

        Alien alien = manager.find(Alien.class,1);
        System.out.println(alien);


        transaction.commit();
        manager.close();
        entityManagerFactory.close();

    }
}