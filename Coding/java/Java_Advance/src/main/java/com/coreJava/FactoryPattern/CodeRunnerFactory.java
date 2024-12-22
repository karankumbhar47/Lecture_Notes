package com.coreJava.FactoryPattern;

import com.coreJava.RunnerClasses.StreamPractice;
import com.coreJava.Random.SubClass;
import com.coreJava.RunnerClasses.CollectionPractice;
import com.coreJava.RunnerClasses.ComparatorPractice;
import com.coreJava.RunnerClasses.EqualityPractice;
import com.coreJava.RunnerClasses.LambdaPractice;
import com.coreJava.RunnerClasses.ListPractice;

public class CodeRunnerFactory{

    public static CodeRunnerInterface createCodeRunner(String type){
        switch (type) {
            case "stream":
                return new StreamPractice();
            case "comp":
                return new ComparatorPractice();
            case "list":
                return new ListPractice();
            case "equal":
                return new EqualityPractice();
            case "random-sub":
                return new SubClass();
            case "lambda":
                return new LambdaPractice();
            case "comparator":
                return new ComparatorPractice();
            case "collection":
                return new CollectionPractice();
            default:
                throw new AssertionError();
        }
    }         
}