package com.core_java.runner_classes.java_8;

import com.core_java.FactoryPattern.CodeRunnerInterface;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        /*
         * Aggregate operation --> operation which aggregates the elements (count, collect, sum ...)
         * Declarative programming --> focus on "what to do" instead of "how to do"
         * (like in stream we are not using loop to iterate the list and doing operation instead we just
         * mentioned what to do with elements and loop will be done by stream (abstract  the loop)
         * once steam used, we can't reuse the same stream
         *
         * process collection in a declarative and functional manner (instead of for loop/ if-else)
         * readability and maintainability (enable parallelism without multithreading complexity)
         * source --> intermediate operation --> terminal operation
         * sequence of an element --> supports -->functional and declarative programming
         *
         * intermediate operation ==> (one stream to another stream)
         * iterate, generate, limit, concat
         * map, filter, distinct, peek, sorted, skip
         * mapToInt, mapToDouble, mapToLong
         * (IntStream, DoubleStream, LongStream) average, sum
         * flatMap, flatMapToInt, flatMapToDouble, flatMapToLong (2d --> 1d array)
         *
         * terminal operation ==>
         * counts, collect, toList, toArray, forEach,
         * anyMatch, allMatch, noneMatch, findFirst, findAny (sort-circuit operation)
         * min, max, reduce (binaryOperator)
         * Collectors methods --> toList, toMap, toSet, toConcurrentMap,
         *                        toUnmodifiableList, toUnmodifiableMap, toUnmodifiableSet
         *
         * Collections methods --> sort, frequency
         */

        List<Integer> list = List.of(1,1,2,2,2,23,4,45,5,6,6);
        Stream<Integer> stream =  list.stream();
        List<Integer> evenNumber = Stream.iterate(0,i -> i+1)
                .limit(100)
                .map(a -> a+5)
                .filter(a  -> a%2==0)
                .toList();

        List<Integer> freq = list.stream()
                .distinct()
                .map(a -> Collections.frequency(list,a))
                .collect(Collectors.toSet())
                .stream()
                .toList();

        Map<Integer, Integer> map = list.stream()
                .distinct()
                .peek(a -> System.out.println("peek "+a))
                .collect(Collectors
                        .toMap(Function.identity(), a -> Collections.frequency(list, a)));
        System.out.println(map);

        double count = freq.stream()
                .filter(a -> a==1)
                .count();

        list.stream().mapToInt(a -> a).average();

        System.out.println(freq);
        System.out.println(count);
        System.out.println(evenNumber);

        //skipping first element
        List<Integer> generateList = Stream.generate(() -> 1)
                .skip(11)
                .limit(50)
                .skip(10)
               .toList();

        System.out.println(generateList.size());
        System.out.println(generateList);

        // toArray
        Object[] objects = Stream.of(1, 2, 2, 3, 9, 4, 5, 10).toArray();

        // min/max
        System.out.println(objects);
        System.out.println(Arrays.stream(objects).map(a -> (Integer) a).max(Comparator.naturalOrder()));
        System.out.println(Arrays.stream(objects).map(a -> (Integer) a).min(Comparator.naturalOrder()));

        //flatMap (transform and flatten)
        List<List<Integer>> listOfList = new ArrayList<>();
        listOfList.add(List.of(1,2,3, 4));
        listOfList.add(List.of(5,6,7,8));
        listOfList.add(List.of(9,10,11,12));
        List<Integer> list1 = listOfList.stream().flatMap(List::stream).toList();
        System.out.println(listOfList);
        System.out.println(list1);

        List<String> sentences = new ArrayList<>(List.of(
                "Hello World",
                "Java is most powerful language",
                "Flatmap sucks"
        ));
        System.out.println(sentences
                .stream()
                .flatMap(a -> Arrays.stream(a.split(" ")))
                .toList());

        // forEachOrdered
        System.out.println("forEach");
        list1.parallelStream().forEach(System.out::println);
        System.out.println("forEach ordered");
        list1.parallelStream().forEachOrdered(System.out::println);
        //parallelStream();
        List<Integer> immList = Arrays.asList(1,2,2,8,3);
        immList.add(1);
    }

    private void parallelStream(){

        /*
         * string.char() --> give array of integers of corresponding chars(stream of integers)
         * */
        String string = "Hello World";
        System.out.println(string.chars().filter(x -> x=='l').count());

        /*
         *  stateful operation ==> knows about other elements
         *  stateless operation ==> don't know about another element from an array
         *  parallel stream --> workload across multiple threads, improve performance on large dataset
         *                  --> independent task, not good for a small task (add overhead)
         * */
        long startTime = System.currentTimeMillis();
        List<Double> factList = Stream
                .iterate(1,i ->i+1)
                .limit(20000)
                .map(StreamPractice::getFactorial)
                .toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential Stream "+(endTime-startTime));

        startTime = System.currentTimeMillis();
        factList = Stream
                .iterate(1,i ->i+1)
                .parallel()
                .limit(20000)
                .map(StreamPractice::getFactorial)
                .toList();
        endTime = System.currentTimeMillis();
        System.out.println("Sequential Stream "+(endTime-startTime));


        List<Integer> intArray = Stream.iterate(1, i -> i + 1).limit(5).toList();
        AtomicInteger currSum = new AtomicInteger(0);

        // not produce a result as per our requirements as tasks do not depend on each other
        List<Integer> cumSum = intArray.parallelStream()
                .sequential() // convert the parallel to sequential
                .map(currSum::addAndGet)
                .toList();
        System.out.println(cumSum);
    }

    private static Double getFactorial(int n){
        double ans = 1;
        for(int i = 1; i<=n; i++)
            ans *= i;
        return ans;
    }
}
