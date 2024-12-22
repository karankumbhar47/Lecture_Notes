package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.models.Alien;
import com.hibernate.models.Laptop;
import com.hibernate.models.Student;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        // ArrayList<Alien> alienList = new ArrayList();
        // alienList.add(new Alien("Yellow",1,new AlienName("Aman","Chaman","Gupta")));
        // alienList.add(new Alien("Red",2,new AlienName("Ritesh","Ramesh","Sharma")));
        // // alienList.add(new Alien("Green",3,"Ramesh"));
        // // alienList.add(new Alien("Yellow",4,"Rohan"));
        // // alienList.add(new Alien("Blue",5,"Abhi"));

        // Configuration config = new Configuration().configure().addAnnotatedClass(Alien.class);
        // ServiceRegistry reg = new StandardServiceRegistryBuilder()
        //         .applySettings(config.getProperties())
        //         .build();
        // SessionFactory sf = config.buildSessionFactory(reg);
        // Session session = sf.openSession();
        // Transaction tx = session.beginTransaction();
        // for(Alien alien: alienList){
        //     session.save(alien);
        // }
        // Alien alien = (Alien)session.get(Alien.class,2); 
        // System.out.println(alien);
        // tx.commit();
        // session.close();
        // sf.close();
        Student student0 = new Student(15, "Aman", 12141120);
        Student student2 = new Student(0, "Sham", 00041120);
        Student student3 = new Student(1, "Rman", 00141120);
        Student student1 = new Student(12, "karan", 12140860);
        Laptop laptop0 = new Laptop("Dell", 0);
        Laptop laptop1 = new Laptop("Mac", 1);
        Laptop laptop2 = new Laptop("Apple", 1293);
        Laptop laptop3 = new Laptop("HP", 1023);

        List<Laptop> list1 = new ArrayList<>();
        list1.add(laptop0);
        list1.add(laptop1);
        // student0.setLaptop(list1);

        List<Laptop> list2 = new ArrayList<>();
        list2.add(laptop2);
        list2.add(laptop3);
        // student1.setLaptop(list2);

        List<Student> list3 = new ArrayList<>();
        list3.add(student0);
        list3.add(student1);

        List<Student> list4 = new ArrayList<>();
        list4.add(student2);
        list4.add(student3);

        // laptop0.setStudent(list3);
        // laptop1.setStudent(list4);
        // laptop2.setStudent(list3);
        // laptop3.setStudent(list4);
        laptop0.setStudent(student0);
        laptop1.setStudent(student0);
        laptop2.setStudent(student1);
        laptop3.setStudent(student1);

        // List<Laptop> list2 = new ArrayList<>();
        // list1.add(laptop1);
        // list1.add(laptop3);
        // laptop0.getStudent().add(student0);
        // laptop0.getStudent().add(student1);
        // laptop2.getStudent().add(student0);
        // laptop1.getStudent().add(student1);
        // laptop3.getStudent().add(student1);
        // student0.setLaptop(list1);
        // student1.setLaptop(list1);
        Configuration config = new Configuration().configure()
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Alien.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();

        SessionFactory sessionFactory = config.buildSessionFactory(registry);
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // session.save(laptop0);
        // session.save(laptop1);
        // session.save(laptop2);
        // session.save(laptop3);
        // session.save(student1);
        // session.save(student0);
        // session.save(student3);
        // session.save(student2);
        // Alien student = (Alien) session.get(Alien.class,1);
        // System.out.println(student);
        // cache while custom query
        Query<Alien> q1 = session
                .createQuery("from Alien where id = 1", Alien.class)
                .setCacheable(true);
        Alien student = q1.uniqueResult();
        System.out.println(student);
        // student.setColor("noColor2");

        // session.persist(student);

        // same query then search in first level cache which is storing result
        // of first query (only available in same session)
        // Student student12 = (Student) session.get(Student.class,49744);
        // System.out.println(student12);
        transaction.commit();
        session.close();

        //first level cache will only work inside the same session
        // so to get this from cache we need to integrate second 
        // level cache which is not provided by hibernate
        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();
        // new query will be done for this request 
        // Alien student13 = (Alien) session2.get(Alien.class,1);
        // System.out.println(student13);

        // cache while custom query
        Query<Alien> q2 = session2
                .createQuery("from Alien where id = 1", Alien.class)
                .setCacheable(true);

        Alien student13 = q2.uniqueResult();
        System.out.println(student13);

        transaction2.commit();
        session2.close();
        sessionFactory.close();

    }
}
