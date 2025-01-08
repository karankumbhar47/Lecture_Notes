package com.core_java.FactoryPattern;

import com.core_java.runner_classes.*;
import com.core_java.runner_classes.Advance.CollectionPractice;
import com.core_java.runner_classes.Advance.ComparatorPractice;
import com.core_java.runner_classes.Advance.EqualityPractice;
import com.core_java.runner_classes.Advance.LambdaPractice;
import com.core_java.runner_classes.Advance.StreamPractice;
import com.core_java.runner_classes.collections.IteratorPractice;
import com.core_java.runner_classes.collections.list.*;
import com.core_java.runner_classes.collections.map.*;
import com.core_java.runner_classes.basics.GCPractice;
import com.core_java.runner_classes.basics.VariablePractice;
import com.core_java.runner_classes.basics.ParamPassing;
import com.core_java.runner_classes.basics.ReferencePractice;
import com.core_java.demo.NonThreadSafeDemo;

import com.core_java.Random.ExceptionDemo;
import com.core_java.Random.SubClass;
import com.core_java.runner_classes.collections.queue.ConcurrentQueuePractice;
import com.core_java.runner_classes.collections.queue.QueueImplPractice;
import com.core_java.runner_classes.collections.queue.QueuePractice;
import com.core_java.runner_classes.collections.set.SetPractice;
import com.core_java.runner_classes.utils.TimeDatePractice;

public class CodeRunnerFactory{

    public static CodeRunnerInterface createCodeRunner(CodeRunnerType  type){
        return switch (type) {
            case STREAM -> new StreamPractice();
            case JAVA8_STREAM -> new com.core_java.runner_classes.java_8.StreamPractice();
            case COMPARATOR -> new ComparatorPractice();
            case EQUAL -> new EqualityPractice();
            case RANDOM_SUB -> new SubClass();
            case RANDOM_EXCEPTION -> new ExceptionDemo();
            case LAMBDA -> new LambdaPractice();

            case COLLECTION -> new CollectionPractice();
            case COLLECTION_ITERATOR -> new IteratorPractice();


            case LIST -> new ListPractice();
            case LIST_ARRAYLIST -> new ArrayListPractice();
            case LIST_ARRAYLIST_THREAD -> new NonThreadSafeDemo();
            case LIST_LINKED_LIST -> new LinkedListPractice();
            case LIST_VECTOR -> new VectorPractice();
            case LIST_STACK -> new StackPractice();
            case LIST_COPY_ON_WRITE -> new CopyOnWritePractice();

            case MAP_HASHMAP -> new HashMapPractice();
            case MAP_LINKED_HASHMAP -> new LinkedHashMapPractice();
            case MAP_LRU_CACHE -> new LRUCache<>(10);
            case MAP_WEAK_HASHMAP -> new WeakHashMapPractice();
            case MAP_ID_HASHMAP -> new IdentityHashMapPractice();
            case MAP_TREE -> new TreeMapPractice();
            case MAP_HASH_TABLE -> new HashTablePractice();
            case MAP_ENUM -> new EnumMapPractice();
            case MAP_IMMUTABLE -> new ImmutableMapPractice();

            case SET -> new SetPractice();
            case QUEUE -> new QueuePractice();
            case QUEUE_IMPL -> new QueueImplPractice();
            case QUEUE_CONCURRENT -> new ConcurrentQueuePractice();

            case OBJECT -> new ObjectMethods();
            case BASIC_VARIABLE -> new VariablePractice();
            case BASIC_GC -> new GCPractice();
            case BASIC_ASSIGN -> new AssignmentPractice();
            case BASIC_PARAM -> new ParamPassing();
            case BASIC_REF -> new ReferencePractice();

            case UTILS_TIME -> new TimeDatePractice();
            default -> throw new AssertionError();
        };
    }         
}
