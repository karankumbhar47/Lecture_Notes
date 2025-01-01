package com.coreJava.RunnerClasses.List;

import java.lang.reflect.Array;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.BaseStream;

import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.RunnerClasses.Advance.LambdaPractice;

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

    public static class InnerClass extends LambdaPractice implements Iterable<Integer>, Runnable {
        @Override
        public void run() {
            throw new UnsupportedOperationException("Unimplemented method 'run'");
        }

        @Override
        public void runCode() {
        }

        @Override
        public Iterator<Integer> iterator() {
            throw new UnsupportedOperationException("Unimplemented method 'iterator'");
        }

        public static void nothing() {
            System.out.println("nothing");
        }

        // abstract void methodName();

    }

    @Override
    public void runCode() {
        ListPractice.quiz();
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

        // question 1
        CodeRunnerInterface.printSeparator(1);
        Iterator<String> it = strings.iterator();
        int i = 0;
        // not able to add and delete element while iterating
        while (it.hasNext()) {
            if (i++ == 2) {
                // it.remove();
                // strings.add(2,"new random element");
                // strings.remove(2);
            }
            System.out.println(it.next());
        }

        // question 3
        CodeRunnerInterface.printSeparator(3);
        List<String> newList = new ArrayList<>();
        newList.add(null);
        newList.add("hello");
        System.out.println(newList);

        // question 4
        CodeRunnerInterface.printSeparator(4);
        newList = strings.subList(3, 6);
        System.out.println(strings);
        System.out.println(newList);
        // this also get updated in new list
        newList.set(0, "new ele");
        System.out.println(strings);
        System.out.println(newList);

        // question 5
        CodeRunnerInterface.printSeparator(5);
        strings.add(1, "Karan");
        strings.add(3, "Karan");
        strings.add("Karan");
        Set<String> setStrings = new HashSet<>(strings);
        Set<String> stringLinkedSet = new LinkedHashSet<>(strings);
        System.out.println(strings);
        System.out.println(setStrings);
        System.out.println(stringLinkedSet);

        // question 6
        CodeRunnerInterface.printSeparator(6);
        System.out.println(strings.contains("Karan"));
        System.out.println(strings.indexOf("Karan"));

        // question 7 (separate class in demo)
        // question 8
        // question 9
        CodeRunnerInterface.printSeparator(9);
        List<Integer> list = Arrays.asList(100, 21, 3, 4, -5, 60);
        list.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer arg0, Integer arg1) {
                System.out.println(arg0 + " " + arg1);
                // return arg0 - arg1;
                return 1;
            }

        });
        System.out.println(list);

        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 8, 1, 2));
        Comparator<Integer> alwaysPositiveComparator = (a, b) -> 1; // Always returns positive
        numbers.sort(alwaysPositiveComparator);
        System.out.println(numbers); // Output: [8, 5, 3, 2, 1]

        // question 10
        CodeRunnerInterface.printSeparator(10);
        List<Integer> numList = new ArrayList<>();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        System.out.println(numList);
        // both 1 and 2 are different
        numList.remove(1); // 1 (here 1 is the index)
        numList.remove(Integer.valueOf(1));// 2 (here 1 is the object)
        System.out.println(numList);

        List<Boolean> boolArray = new ArrayList<>();
        boolArray.add(false);
        boolArray.add(true);
        boolArray.add(true);
        boolArray.add(false);
        boolArray.add(true);
        System.out.println(boolArray);
        // boolArray.remove(false);
        boolArray.remove(1);
        System.out.println(boolArray);

        // question 14
        CodeRunnerInterface.printSeparator(14);
        List<Integer> nullList = Arrays.asList(13, 5, null, 2, 1, 5, null);
        nullList.sort(Comparator.nullsLast(Comparator.naturalOrder()));
        System.out.println(nullList);

        // question 15
        CodeRunnerInterface.printSeparator(15);
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Float> list2 = Arrays.asList(1f, 2f, 3f, 4f);
        System.out.println(list1.equals(list2));
        System.out.println();

        // practice
        list1 = Arrays.asList(2, 1, 4, 3);
        list1.sort((a, b) -> {
            System.out.println(a + " " + b);
            return a - b;
        });
        System.out.println(list1);

    }

    private static void quiz() {
        List<Integer> list = Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 5, 3);
        ListIterator<Integer> it = list.listIterator();

        while (it.hasNext())
            System.out.println(it.next());
        System.out.println("new loop");
        while (it.hasPrevious())
            System.out.println(it.previous());

        // List<Integer> l = Array.list(5, 10, 12, 30, 8, 7);
        int arr[] = { 30, 20, 10  };
        int arr1[] = { 30, 20, 10  };
        System.out.println(arr1.equals(arr));
        // int temp = (int) Arrays.stream(arr).average().getAsDouble();

        Double object = Double.parseDouble("2.4");
        System.out.println(object);
        int a = object.intValue();
        byte b = object.byteValue();
        float d = object.floatValue();
        double c = object.doubleValue();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        System.out.println(a + b + c + d );
        // Type promotion
    }
    
}
