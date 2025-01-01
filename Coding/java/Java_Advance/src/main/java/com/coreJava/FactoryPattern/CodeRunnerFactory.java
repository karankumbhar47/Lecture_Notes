package com.coreJava.FactoryPattern;

import com.coreJava.RunnerClasses.*;
import com.coreJava.RunnerClasses.Advance.CollectionPractice;
import com.coreJava.RunnerClasses.Advance.ComparatorPractice;
import com.coreJava.RunnerClasses.Advance.EqualityPractice;
import com.coreJava.RunnerClasses.Advance.LambdaPractice;
import com.coreJava.RunnerClasses.Advance.StreamPractice;
import com.coreJava.RunnerClasses.List.ArrayListPractice;
import com.coreJava.RunnerClasses.List.CopyOnWritePractice;
import com.coreJava.RunnerClasses.List.LinkedListPractice;
import com.coreJava.RunnerClasses.List.ListPractice;
import com.coreJava.RunnerClasses.List.StackPractice;
import com.coreJava.RunnerClasses.Map.HashMapPractice;
import com.coreJava.RunnerClasses.Map.LRUCache;
import com.coreJava.RunnerClasses.Map.LinkedHashMapPractice;
import com.coreJava.RunnerClasses.basics.GCPractice;
import com.coreJava.RunnerClasses.basics.VariablePractice;
import com.coreJava.RunnerClasses.basics.ParamPassing;
import com.coreJava.RunnerClasses.basics.ReferencePractice;
import com.coreJava.demo.NonThreadSafeDemo;

import com.coreJava.Random.ExceptionDemo;
import com.coreJava.Random.SubClass;

public class CodeRunnerFactory{

    public static CodeRunnerInterface createCodeRunner(CodeRunnerType  type){
        return switch (type) {
            case STREAM -> new StreamPractice();
            case COMPARATOR -> new ComparatorPractice();
            case EQUAL -> new EqualityPractice();
            case RANDOM_SUB -> new SubClass();
            case RANDOM_EXCEPTION -> new ExceptionDemo();
            case LAMBDA -> new LambdaPractice();
            case COLLECTION -> new CollectionPractice();
            case LIST -> new ListPractice();
            case LIST_ARRAYLIST -> new ArrayListPractice();
            case LIST_ARRAYLIST_THREAD -> new NonThreadSafeDemo();
            case LIST_LINKED_LISt -> new LinkedListPractice();
            case LIST_STACK -> new StackPractice();
            case LIST_COPY_ON_WRITE -> new CopyOnWritePractice();
            case MAP_HASHMAP -> new HashMapPractice();
            case MAP_LINKED_HASHMAP -> new LinkedHashMapPractice();
            case MAP_LRU_CACHE -> new LRUCache(10);
            case OBJECT -> new ObjectMethods();
            case BASIC_VARIABLE -> new VariablePractice();
            case BASIC_GC -> new GCPractice();
            case BASIC_ASSIGN -> new AssignmentPractice();
            case BASIC_PARAM -> new ParamPassing();
            case BASIC_REF -> new ReferencePractice();
            default -> throw new AssertionError();
        };
    }         
}
