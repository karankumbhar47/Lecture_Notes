package com.core_java.runner_classes.collections.map;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentHashMapPractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
        /*
         hashtable --> at one time, hashtable only can operate on a single thread
         which became its limitation (as read thread is waiting while
         one of the threads is writing the value, which is not necessary

         so overcome this issue one we use concurrent hashMap

        java 7 --> a segment-based lock (by default 16 segment --> smaller hashMaps)
         individual segment has their own locks
         only required segment gets locked
         read: do not require lock unless write operation happening on the same the segment
         write: always lock

         java 8 --> no segmentation
         as fragmentation will create fragments of bigger size when the size of map gets higher
         So the waiting time is more
         --> compare and swap (compare old value(when last time it watch the value) and value
         at time of setting if they are equal then only operation happens otherwise thread
         will wait and retry, if a lot of retry will happen then it will back off)
         no locking require in compare and swap operation
         --> locking at resizing and collision time(only at that index)
         --> individual locks will only lock single bucket

         --> in hashmap capacity will get doubled when hashmap size is greater than
         loadFactor * capacity, but this will not happen in concurrentHashMap
         re-size --> incremental resizing(adding one bucket)
         */

        // higher number of concurrency levels means all operations get slower
        ConcurrentHashMap<Integer,String> concurrentHashMap = new ConcurrentHashMap<>(10,0.8f,80);
        // null values are not allowed  as key
        //concurrentHashMap.put(null,"hello");
        //concurrentHashMap.put(1,null);
    }

    private void concurrentSkipListMap() {
        /*
        * we want to store things in a sorted manner but also with synchronized manner
        * Map ==> Thread Safe, Sorted === concurrentSkipListMap <-> Here data store in new datatype (Skip List)
        * Skip List --> probabilistic data structure, allows efficient insertion/deletion/search
        * similar to sorted linked list(multiple layers)
        *
        * skip list has layers that contain values less than the previous layer (while searching it will start from
        * top layer to bottom) where the top layer has very fewer numbers than the bottom one). The Overall time complexity
        * of the searching element in the list is log(n). Also data storage is straightforward (when you try to add a
        * new element in the list, possibly it will only modify the bottom layers not the top one)
        * list is --> 1,2,3,4,5,6,7,8,9
        * then layers are
        *
        * 3 --> 1,----- 5,----- 9
        * 2 --> 1,- 3,- 5,- 7,- 9
        * 1 --> 1,2,3,4,5,6,7,8,9
        *
        * As in the above level top level have very lower number of elements than bottom one,
        * while searching elements, it will skip the list from top if an element is not found.
        *
        * We are introducing skip list data structure to achieve concurrency with simple data storage,
        * as in treeMap we have self-balancing tree (which needs complex algorithms to balance it, which is then
        * not easy to achieve concurrency)
        *
         */
        ConcurrentSkipListMap<Integer, String> map = new ConcurrentSkipListMap<>();
        map.put(1,"Hello");
        map.put(2,"Hello");
        map.put(3,"Hello");
        map.put(4,"Hello");
    }
}
