package com.core_java.runner_classes.collections;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.*;

public class collectionsPractice implements CodeRunnerInterface {
    // string reverse method

    @Override
    public void runCode() {
        //Collections.syn
        // collections reverse method return type
        List<Integer> list = List.of(1,2,2,2,2,3,2);
        List<Integer> newInteger = Collections.synchronizedList(list);
        Collections.reverse(list);
        Collections.sort(list);
        System.out.println(Collections.frequency(list,2));

        Set<Integer> set = new HashSet<>(list);
        Map<Integer,Integer> map =new HashMap<>(Map.of(1,2,2,3,4,5,6,7,8,9));

        // synchronized methods
        // below method will wrap a collection with synchronized block
        // every operation is now synchronized | we just need to add synchronized block
        // around the iteration.
        // every operation is now blocking means at a time only on thread can access the
        // collection, that means performance is very poor in such methods
        List<Integer> syncList = Collections.synchronizedList(list);
        // here we have to add synchronize block manually to iteration
        Iterator<Integer> iterator = syncList.iterator();
        synchronized (syncList){
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }

        /* Immutable Collections */
        List<Integer> immutableList = Collections.unmodifiableList(syncList);
        Set<Integer> immutableSet = Collections.unmodifiableSet(set);
        Map<Integer,Integer> immutableMap = Collections.unmodifiableMap(map);


    }
}
