package com.core_java.runner_classes.collections.set;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        /*
         Set is the same as hashmap only (as it is internally using hashmap to store the values
         as a key with some dummy value, as keys are set only).
         All operation time complexities of the set are the same as the hashmap.(also same hierarchy as the
         hashmap like
         Set --> sortedSet --> navigableSet --> TreeSet
         Set --> HashSet --> LinkedHashSet
         But methods like list, like add, remove, ...

          Also, HashSet, LinkedHashSet, TreeSet, EnumSet are not thread safe
         */
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        Set<Integer> set3 = new TreeSet<>();
        //Set<CodeRunnerType> set4 = new En;

        set1.add(1);
        set1.add(12);
        set1.add(3);
        set1.add(1);
        set1.add(-5);
        System.out.println(set1);

        threadSafeSets();

        // immutable set
        Set<Integer> integerSet = Set.of(1,2,3,4,5,6,7,8,9,10,11,12);
        System.out.println(integerSet);

        List<Integer> simpleLIst = new ArrayList<>(List.of(1,1,1,2,2,2,3,3,3,4));
        List<Integer> list1 = Collections.unmodifiableList(simpleLIst);
        Set<Integer> simpleSet = new HashSet<>(list1);
        Set<Integer> unModifiedSet = Collections.unmodifiableSet(simpleSet);
        System.out.println("immutable");
        System.out.println(simpleLIst);
        System.out.println(list1);
        System.out.println(simpleSet);
        System.out.println(unModifiedSet);

        copyOnWriteSets();
    }

    private void threadSafeSets(){
        /*
         * So to achieve concurrency, we can use 2 methods as follows,
         * but the best one is Concurrent Skip List Set as it have internal implementation
         * for the concurrency.
         * As Collections.synchronizedSet method will only wrap methods with synchronized block
         * which leads to poor performance also need to add synchronized block manually to iteration block.
         *
         * Skip list also has a requirement that elements are in sorted manner
         */
        ConcurrentSkipListSet<Integer> threadSafeSet = new ConcurrentSkipListSet<>();
    }

    private void copyOnWriteSets(){
        /*
        * In skip list, things are in sorted manner,
        * but here it stores an element in a list and use copy on write principle while modification.
        * Also, it will not show modification (latest changes) until completion of the loop.
        *
        * Thread safe, copy on a writing mechanism, Iteration will not show modification.
        * But in a concurrent skip list mechanism it may show or may not show the modification
        * while iteration, so we called a skip list as weakly consistency.
        *
        * But if more write operation is theirs, then copy on a write list will not work properly means it take a lot of
        * memory to create a new copy of the previous one. So only use copy on write when read intensive operations are
        * their
        * And for frequent read and write operation are thier then use skip list (as it have balance here)
        *
        * */
        // case 1
        CopyOnWriteArraySet<Integer> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        ConcurrentSkipListSet<Integer> concurrentSkipListSet = new ConcurrentSkipListSet<>();
        for(int i=0; i<5; i++){
            copyOnWriteArraySet.add(i);
            concurrentSkipListSet.add(i);
        }

        System.out.println(copyOnWriteArraySet.size());
        System.out.println(concurrentSkipListSet.size());

        for(int i: copyOnWriteArraySet){
            System.out.println("Element from the copy on write set : "+i);
            copyOnWriteArraySet.add(5);
        }

        System.out.println(copyOnWriteArraySet);

        // case 2
        // concurrent skip list showing modification
        System.out.println("\nShowing modification");
        for(int i: concurrentSkipListSet){
            System.out.println("Element from the concurrent skip list set : "+i);
            concurrentSkipListSet.add(6);
        }
        System.out.println("\nend list "+concurrentSkipListSet);

        System.out.println("\nNot showing modification");
        // concurrent skip list not showing modification
        for(int i: concurrentSkipListSet){
            System.out.println("Element from the concurrent skip list set : "+i);
            if(i==6){
                concurrentSkipListSet.add(7);
            }
        }
        System.out.println("\n end list "+concurrentSkipListSet);
    }
}
