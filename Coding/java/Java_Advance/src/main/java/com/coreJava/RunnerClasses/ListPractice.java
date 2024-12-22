package com.coreJava.RunnerClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import com.coreJava.FactoryPattern.CodeRunnerInterface;

abstract class DummyInterface1 {
    public abstract void helloMethod();

    private static void noMethod() {
        System.out.println("some private method");
    }

    protected static void someRandomMethod() {
        System.out.println("protected method");
        noMethod();
    }

    private void helloPrivate() {
        System.out.println("hello private");
    }
}

public class ListPractice implements CodeRunnerInterface {
    @FunctionalInterface
    interface InnerListPractice {
        void run();
    }

    static class InnerClass extends LambdaPractice implements Iterable<Integer>, Runnable {
        @Override
        public void run() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'run'");
        }

        @Override
        public void runCode() {

        }

        @Override
        public Iterator<Integer> iterator() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'iterator'");
        }

        public static void nothing() {
            System.out.println("nothing");
        }

        // abstract void methodName();

    }

    @Override
    public void runCode() {
        ListPractice.practice();
        // ListPractice.main(null);
    }

    public static void main(String[] args) {
        // List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        // int[] arr1 = new int[] { 1, 2, 3, 4, 5 };

        // arr.forEach(x -> System.out.println(x));
        // for (int i : arr1)
        // System.out.println(i);

        // arr = Arrays.asList(1, 2, 3);
        // // type mismatch
        // // arr1 = Arrays.asList(1,2,3,5,6);

        // String[] stringArray = new String[] { "Hello", "This", "is", "Karan" };
        // List<String> stringArray1 = Arrays.asList("Hello", "This", "is", "Karan");
        // stringArray1.forEach(System.out::println);
        // System.out.println(Arrays.toString(stringArray));

        // stringArray1 = Arrays.asList("New", "Array", "Created");
        // type mismatch
        // stringArray = Arrays.asList("New","Array","Created");

        DummyInterface1 dummyInterface = new DummyInterface1() {
            @Override
            public void helloMethod() {
                System.out.println("hello");
            }

            public void method1() {
                System.out.println("method1");
            }

            public void someRandomMethod1() {
                System.out.println("hello from me");
            }

        };

        DummyInterface1.someRandomMethod();

        // InnerListPractice innerListPractice = new InnerListPractice() {
        // // this anonymous class extending interface named as innerListPractice

        // @Override
        // public void run() {
        // throw new UnsupportedOperationException("Unimplemented method 'run'");
        // }

        // public void alsoAnotherFunction() {
        // return;
        // }

        // };

        // InnerClass.nothing();
    }

    private static void practice() {
        // question 1
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("This");
        strings.add("is");
        strings.add("Karan");
        strings.add("Hey");
        strings.add("new element");

        Iterator<String> it = strings.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (i++ == 2)
                it.remove();
                // strings.add(2,"new random element");
                // strings.remove(2);
            System.out.println(it.next());
        }

        // AtomicInteger j = new AtomicInteger(0);
        // strings.forEach(x -> {
        // if (j.incrementAndGet() == 2)
        // strings.set(2, "something random");
        // System.out.println(x);
        // });

        // question 3
        List<String> newList = new ArrayList<>();
        newList.add(null);
        newList.add("hello");
        System.out.println(newList);

        // question 4
        newList = strings.subList(3, 6);
        System.out.println(strings);
        System.out.println(newList);

        // question 5
        strings.add("Karan");
        Set<String> setStrings = new HashSet<>(strings);
        System.out.println(strings);
        System.out.println(setStrings);

        // question 14
        List<Integer> nullList = Arrays.asList(13, 5, null, 2, 1, 5, null);
        nullList.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println(nullList);

        // question 15
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Float> list2 = Arrays.asList(1f, 2f, 3f, 4f);
        System.out.println(list1.equals(list2));
        System.out.println();

    }

}
