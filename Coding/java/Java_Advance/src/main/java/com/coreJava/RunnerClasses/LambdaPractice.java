package com.coreJava.RunnerClasses;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

@FunctionalInterface
interface InnerLambdaPractice {
    void runMethod();
}

public class LambdaPractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
        LambdaPractice.main(null);
    }

    private static String prefix;
    private static int x = 0;

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Lambda", "Functions", "in", "Java");

        // String prefix = "Word: ";
        prefix = "Word: ";

        UnaryOperator<String> changeFunction = word -> {
            String suffix = "!";
            return prefix.concat(word).concat(suffix);
        };

        words.replaceAll(changeFunction);

        words.forEach(System.out::println);

        prefix = "Modified: ";
        someRandomFunction(changeFunction);

        List<Integer> numbers = Arrays.asList(4, 2, 3, 1, 5);
        numbers.sort(Comparator.comparingInt(x -> x)); // Will this compile?
        numbers.sort(Integer::compare);
        System.out.println(numbers);

        InnerLambdaPractice newClass = new InnerLambdaPractice() {
            @Override
            public void runMethod() {
                System.out.println("Hello from inner class");
            }
        };

        newClass.runMethod();

        numbers = Arrays.asList(1, 2, 3, 4, 5);
        numbers.stream()
                .filter(n -> {
                    System.out.println("Filtering: " + n);
                    return n > 2;
                })
                .map(n -> {
                    System.out.println("Mapping: " + n);
                    return n * 2;
                })
                .collect(Collectors.toList());

        Runnable r = () -> {
            x = x + 5; 
            System.out.println(x);
        };
        r.run();
    }

    private static void someRandomFunction(UnaryOperator<String> un) {
        System.out.println(un.apply("hello"));
    }

}
