package com.hibernate;

import java.util.ArrayList; 

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.models.Alien;

public class FillData{
    public static void fillData(){
        // ArrayList<Alien> alienList = new ArrayList();
        // alienList.add(new Alien("Yellow",1,"Aman"));
        // alienList.add(new Alien("Red",2,"Chaman"));
        // alienList.add(new Alien("Green",3,"Ramesh"));
        // alienList.add(new Alien("Yellow",4,"Rohan"));
        // alienList.add(new Alien("Blue",5,"Abhi"));

        // Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        // ServiceRegistry reg = new StandardServiceRegistryBuilder()
        //         .applySettings(config.getProperties())
        //         .build();

        // try (SessionFactory sf = config.buildSessionFactory(reg); Session session = sf.openSession()) {
            
        //     Transaction tx = session.beginTransaction();
            
        //     for(Alien alien: alienList){
        //         System.out.println(alien);
        //     }
        //     session.save(alienList.get(0));
            
        //     tx.commit();
        // }

    }
}
