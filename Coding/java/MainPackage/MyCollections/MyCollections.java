package MainPackage.MyCollections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;
import java.util.Arrays;
import java.util.Iterator;

import MainPackage.MyException;

public class MyCollections {
    public static void main(String[] args) {
        int intArr[] = new int[10];
        intArr[0] = 3;
        intArr[1] = 4;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(11);
        list.add(12);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(12);

        // method of collection
        // System.out.println("list size "+list.size());
        // System.out.println("list empty "+list.isEmpty());
        // list.remove(Integer.valueOf(10)); // removing object
        // list.remove(0); // removing index
        // System.out.println(list.contains(12)); //O(n)
        // list.addAll(list2);
        // list.removeAll(list2);// remove intersection
        // list.retainAll(list2);// only keep intersection
        // // list.clear(); // O(1)
        // Object listToArr[] = list.toArray();
        // for(Object object: listToArr) System.out.println(object);

        // list methods
        System.out.println(list.get(0));
        System.out.println(list.set(0, 3));
        list.add(3, 4); // insert element at index 3 // O(n)
        list.remove(0);// from list method (override from collection)
        System.out.println(list.indexOf(4));
        System.out.println(list.lastIndexOf(4));

        List<String> stringList = new ArrayList<>();
        stringList = Arrays.asList("first", "second", "third");

        Iterator<String> it = stringList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Iterator<Integer> it1 = list.iterator();
        Iterator<Integer> it2 = list.listIterator();
        while (it1.hasNext() || it2.hasNext()) {
            System.out.println(it1.next() + it2.next());
        }

        List<String> subList = stringList.subList(0, 2);
        System.out.println(subList);

        // List<String> stringList = new ArrayList<>();
        // stringList.add("not null");

        // for (String item : stringList) {
        // System.out.println(item);
        // }
        // for (String item : stringList) {
        // System.out.println(item);
        // }

        // Stack<MyException> st = new Stack<>();
        // st.push(new MyException("first"));
        // st.push(new MyException("second"));
        // st.push(new MyException("third"));

        // Collection<String> coll = new ArrayList<>();
        // coll.add("hello");
        // System.out.println(coll.isEmpty());
    }
}
