package com.core_java.runner_classes.basics;

import com.core_java.FactoryPattern.CodeRunnerInterface;
import com.core_java.models.Student;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class SomeClass{
    private int id;
    private String Name;

    public SomeClass(int id, String name) {
        this.id = id;
        Name = name;
    }

    @Override
    public String toString() {
        return "someClass{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

public class GCPractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
//        System.out.println("\nStrong reference");
//        strongReference();
//
//        System.out.println("\nWeak reference");
//        weakReference();
//
//        System.out.println("\nSoft reference");
//        softReference();

        System.out.println("\nPhantom reference");
        phantomReference();
    }

    private void strongReference(){
        // here is a strong reference to the object
        // with name hello and roll number 1
        Student s = new Student("Hello",1);
        System.out.println(s);
        // nullifying strong reference then object with name Hello and roll number 1
        // will be automatically collected by garbage collector
        s = null;
        System.out.println(s);
    }

    private void weakReference(){
        // here is a strong reference to object with roll number 1
        SomeClass s = new SomeClass(1,"Hello");

        // s will act as referent to weak reference of an object with roll number 1
        // this will be removed when a garbage collector is called
        WeakReference<SomeClass> studentWeakReference = new WeakReference<>(s);
        // nullify the strong reference then gc will remove weak reference  automatically
        s = null;
        System.gc();
        try { Thread.sleep(10000);
        }catch (Exception ignored){}

        System.out.println(s);
        // both will be null (as gc will remove weak reference as no object reference
        // is their to point out
        System.out.println(studentWeakReference.get());

        /* * case 2 */
        // as no strong reference to a referent object so reference will be deleted by gc
        WeakReference<SomeClass> reference = new WeakReference<>(new SomeClass(1,"hello"));
        System.gc();
        try { Thread.sleep(10000);
        }catch (Exception ignored){}
        System.out.println(studentWeakReference.get());
    }

    private void softReference(){
        // the only difference in weak reference and soft reference is that
        // soft reference only removed when memory is full and need to
        // free some memory block
        // generally used in caching (not a good type of caching)
        // case 1
        SomeClass someClass = new SomeClass(1,"Karan");
        SoftReference<SomeClass> softReference = new SoftReference<>(someClass);
        someClass = null;
        System.gc();

        try {Thread.sleep(10000);}
        catch (Exception ignored){}

        System.out.println(someClass);
        System.out.println(softReference.get());


        // case 2
        SoftReference<SomeClass> reference = new SoftReference<>(new SomeClass(1,"Karan"));
        System.gc();
        try {Thread.sleep(10000);}
        catch (Exception ignored){}
        System.out.println(reference);
    }

    private void phantomReference(){
        ReferenceQueue<SomeClass> queue = new ReferenceQueue<>();
        ArrayList<SomeClass> list = new ArrayList<>();
        ArrayList<PhantomReference<SomeClass>> referenceArrayList = new ArrayList<>();
        for(int i=0; i<10; i++){
            SomeClass someClass = new SomeClass(1,"name_"+i);
            PhantomReference<SomeClass> ref = new PhantomReference<>(someClass,queue);

            list.add(someClass);
            referenceArrayList.add(ref);
        }

        System.out.println(list);
        System.out.println(referenceArrayList);
        list = null;

        System.out.println(list);
        referenceArrayList.forEach(x -> System.out.println(x.get()));
    }
}
