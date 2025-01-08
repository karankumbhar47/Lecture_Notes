package com.core_java.runner_classes.java_8;

import com.core_java.FactoryPattern.CodeRunnerInterface;

import java.util.List;
import java.util.function.*;

public class Java8Practice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        /*
         * java 8 --> minimal code, functional programming (treating functions as variable)
         *        --> lambada expression, Streams, Date and Time Api
         * lambda --> anonymous function (no name, no modifier)
         *        --> used to implement functional interfaces (method with abstract method)
         *  */
        Thread thread = new Thread( () -> System.out.println("hello"));

        /* predicate is functional interface  */
        Predicate<Integer> predicate = a -> a > 2;
        Function<Integer,Integer> function = a -> a+2;
        Function<Integer,Integer> function1 = a -> a+3;
        Function<Integer,Integer> function3 = function.andThen(function1);

        // first function and then function1 in composing
        System.out.println(function1.compose(function));
        System.out.println(function.apply(2));
        System.out.println(predicate.test(2));
        System.out.println(function3.apply(1));

        // the same input will be returned
        Function<Integer,Integer> function2 = Function.identity();
        System.out.println(function2.apply(4));

        // also contains andThen funciton
        Consumer<Integer> consumer = x -> System.out.println(x);
        consumer.accept(4);

        Supplier<String> supplier = () -> "Hello world";
        System.out.println(supplier.get());

        BiPredicate<Integer,Integer> biPredicate = (a,b)-> a+b > 2;
        BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + " " + b);
        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b;

        // same return type and input type (function)
        UnaryOperator<Integer> unaryOperator = (a) -> a * a;
        // same return type and input type (biFunction)
        BinaryOperator<Integer> binaryOperator = (a,b) -> a*b;

        /*
        * Method reference
        * used for lambda expression (no need to invocation)
        * method as parameter
        * */
        List<Integer> list = List.of(1,2,1,2,2,12,1,21,1,2);
        list.forEach(System.out::println);

        List<Phone> list1 = list.stream().map(Phone::new).toList();

    }
}

class Phone{
    private Integer  score;
    public Phone(Integer score){
        this.score = score;
    }
}