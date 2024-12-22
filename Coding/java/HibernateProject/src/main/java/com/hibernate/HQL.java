package com.hibernate;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.models.Student;

public class HQL {

    public static void main(String[] args) {
        Configuration config = new Configuration().configure()
                .addAnnotatedClass(Student.class);
        ServiceRegistry registery = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();

        SessionFactory sessionFactory = config.buildSessionFactory(registery);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Student student;
        Random random = new Random();

        // for(int i=1; i<50; i++){
        //     student = new Student(random.nextInt(0,100),"name"+i,i);
        //     session.save(student);
        // }
        // Query<Student> query = session.createQuery("from Student where marks > 50 and rollNumber = 13", Student.class);
        // List<Student> studentList = query.list();
        // for(Student student1: studentList){
        //     System.out.println(student1);
        // }
        // Query<Object[]> query1 = session.createQuery("select rollNumber,marks,name from Student where marks > 90 ",Object[].class);
        // List<Object[]> students = (List<Object[]>) query1.list();
        // for(Object[] oi : students){
        //     System.out.println(oi[0]+" "+oi[1]+" "+oi[2]);
        // }
        // int threshold = 50;

        // // prepared statement 
        // Long marks = session
        //         .createQuery("select sum(marks) from Student where marks > ?1 and rollNumber > ?2", Long.class)
        //         .setParameter(1, threshold)
        //         .setParameter(2, 33)
        //         .uniqueResult();
        // System.out.println("marks : " + marks);

        // native sql query
        // NativeQuery<Object[]> sqlQuery = session.createNativeQuery("select name,rollNumber from Student", Object[].class);
        // addEntity
        // for (Student s : sqlQuery.list()) {
        //     System.out.println(s);
        // }

        // for (Object[] oi : sqlQuery.list()) {
        //     System.out.println(oi[0]+" : " + oi[1] ) ;
        // }

        // //new state object
        // Student newStudent = new Student(123,"newStudent",233);
        
        // // persistance state
        // session.save(newStudent);

        // // object is still in persistance state 
        // // so value will be update in database
        // newStudent.setMarks(49);

        // // object in removed state
        // // object is no longer in database
        // session.remove(newStudent);
        // // no use of updating object 
        // // will not reflect in database
        // newStudent.setMarks(50);

        // // detach state
        // session.detach(newStudent);
        // System.out.println(student1);


        // get
        Student student1 = session.get(Student.class,21);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
        System.out.println(student1);
        

        //load
        Student student2 = session.load(Student.class,21);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
        }
        System.out.println(student2);

        transaction.commit();
        session.close();
        sessionFactory.close();

    }
}
