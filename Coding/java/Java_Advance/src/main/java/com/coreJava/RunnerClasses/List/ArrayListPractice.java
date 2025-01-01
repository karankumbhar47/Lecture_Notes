package com.coreJava.RunnerClasses.List;

import java.lang.reflect.Array;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.*;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class ArrayListPractice implements CodeRunnerInterface,Cloneable {
    public static void main(String[] args) {
        // question 20
        CodeRunnerInterface.printSeparator(20);
        ArrayList<Integer> numList = new ArrayList<>(
                Arrays.asList(3, 3, 0, 2, 4, 4, 2, 4, 4));
        Optional<Integer> maxCount = numList.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > numList.size() / 2)
                .map(x -> x.getKey())
                .findFirst();
        System.out.println(maxCount.orElse(-1));

        // question 19
        CodeRunnerInterface.printSeparator(19);
        List<Integer> elements = Arrays.asList(50, 40, 70, 60, 90);
        List<Integer> indices = Arrays.asList(3, 0, 4, 1, 2);
        List<Integer> newList = new ArrayList<>(Collections.nCopies(elements.size(), null));
        IntStream.range(0, elements.size())
                .forEach(x -> {
                    int index = indices.get(x);
                    int element = elements.get(x);
                    newList.set(index, element);
                });
        System.out.println(elements);
        System.out.println(indices);
        System.out.println(newList);

        // question 18
        CodeRunnerInterface.printSeparator(18);
        List<Integer> numbers = Arrays.asList(4, 3, 2, 7, 8, 2, 3, 1);
        List<Integer> newNumbers = numbers.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(x -> x.getValue() > 1)
                .map(x -> x.getKey())
                .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(newNumbers);

        List<Integer> nums = new ArrayList<>(Arrays.asList(4, 3, 2, 7, 8, 2, 3, 7));
        List<Integer> duplicates = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int index = Math.abs(nums.get(i)) - 1;
            if (nums.get(index) < 0)
                duplicates.add(Math.abs(nums.get(i)));
            else
                nums.set(index, -nums.get(index));
        }
        System.out.println("Duplicates: " + duplicates);

        // question 17
        CodeRunnerInterface.printSeparator(17);
        nums = Arrays.asList(1, 2, 4, 6, 3, 7, 8);
        int n = nums.size() + 1;
        int sum = nums.stream().mapToInt(x -> Integer.valueOf(x)).sum();
        System.out.println(((n * (n + 1)) / 2) - sum);

        // question 16
        CodeRunnerInterface.printSeparator(16);
        nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        newNumbers = new ArrayList<>(nums.size());
        int low = 0, i = 0;
        int high = nums.size() - 1;
        while (low <= high && i < nums.size()) {
            if ((i++ & 1) == 0)
                newNumbers.add(nums.get(high--));
            else
                newNumbers.add(nums.get(low++));
        }
        System.out.println(newNumbers);

        // question 15
        CodeRunnerInterface.printSeparator(15);
        List<Integer> input = Arrays.asList(4, 5, 6, 5, 4, 3, 1, 1, 1);
        Map<Integer, Long> freqMap = input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(input);
        input.sort((a, b) -> {
            if (freqMap.get(a) != freqMap.get(b))
                return freqMap.get(b).compareTo(freqMap.get(a));
            return a - b;
        });
        System.out.println(input);

        // question 14
        CodeRunnerInterface.printSeparator(14);
        input = Arrays.asList(1, 2, 3);
        // List<List<Integer>> output = giveCombination(input, input.size() - 1);
        List<List<Integer>> output = giveCombMask(input);
        System.out.println(input);
        System.out.println(output);

        // question 13
        CodeRunnerInterface.printSeparator(13);
        input = Arrays.asList(1, 2, 3, 4, 1, 4, 5);
        output = getTargetPairs(input, 5);
        // List<List<Integer>> result = getTargetPairsMap(input,5);
        System.out.println(input);
        System.out.println(output);

        // question 12
        CodeRunnerInterface.printSeparator(12);
        input = Arrays.asList(1, -2, 0, 2, 3, 3, -2, 3, -4, -5, 6);
        List<Integer> result = input.stream().sorted((a, b) -> {
            if (a >= 0 && b >= 0)
                return 0;
            if (a < 0 && b < 0)
                return 0;
            if (a >= 0 && b < 0)
                return 1;
            return -1;
        }).collect(Collectors.toList());
        System.out.println(input);
        System.out.println(result);

        // question 10
        CodeRunnerInterface.printSeparator(10);
        input = Arrays.asList(2, 7, 3, 1, 2, 4, 37);
        result = getSubList(input, 7);
        System.out.println(input);
        System.out.println(result);

        // question 9
        CodeRunnerInterface.printSeparator(9);
        input = Arrays.asList(1, 2, 3, 4, 5);
        int k = 4;
        n = input.size();
        result = Stream.concat(input.stream(), input.stream())
                .collect(Collectors.toList())
                .subList(n - k, 2 * n - k);
        System.out.println(input);
        System.out.println(result);

        // question 1
        CodeRunnerInterface.printSeparator(1);
        ArrayList<Integer> numList1 = new ArrayList<>(Arrays.asList(
                3, 3, 0, 2, 4, 4, 2, 4, 4));
        // for (i = 0; i < numList1.size(); i++) {
        // if (numList1.get(i) % 2 == 0)
        // numList1.remove(i);
        // }
        System.out.println(numList);
        Iterator<Integer> it = numList1.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0)
                it.remove();
        }
        System.out.println(numList1);

        // question 2
        CodeRunnerInterface.printSeparator(2);
        List<String> words = Arrays.asList("Apple", "banana", "Cherry", "apple");
        System.out.println(words);
        words.sort((a, b) -> {
            int cmp = b.compareToIgnoreCase(a);
            if (cmp == 0)
                return a.compareTo(b);
            return cmp;
        });
        System.out.println(words);

        // question 3
        CodeRunnerInterface.printSeparator(3);
        System.out.println(numList);
        Collections.shuffle(numList);
        System.out.println(numList);

        // question 4
        CodeRunnerInterface.printSeparator(4);
        System.out.println(numList);
        // for (Integer a : numList) {
        // if(a%2==0)
        // numList.remove(a);
        // }
        numList.removeIf(x -> x % 2 == 0);
        System.out.println(numList);

        // question 5
        CodeRunnerInterface.printSeparator(5);
        ArrayList<Integer> intList = new ArrayList<>();
        LinkedList<Integer> linkList = new LinkedList<>();
        n = 100000;
        long start = System.currentTimeMillis();
        for (i = 0; i < n; i++) {
            intList.add(0, i);
        }
        long end = System.currentTimeMillis();
        System.out.println("Arraylist time : " + (end - start));

        start = System.currentTimeMillis();
        for (i = 0; i < n; i++) {
            linkList.add(0, i);
        }
        end = System.currentTimeMillis();
        System.out.println("linkList time : " + (end - start));

        // question 6
        Integer a = Integer.valueOf(1);
        int b = a.intValue();
        CodeRunnerInterface.printSeparator(6);
        numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 4);
        Map<Integer, Long> freqMap1 = numbers.stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));
        System.out.println(freqMap1);

        // question 7
        CodeRunnerInterface.printSeparator(7);
        List<Integer> list = new ArrayList<>(List.of(1, 2, 2, 3, 4, 4, 4));
        System.out.println(list);
        list = list.stream().distinct().collect(Collectors.toList());
        System.out.println(list);

        // question 8
        CodeRunnerInterface.printSeparator(8);
        input = Arrays.asList(100, 4, 200, 1, 3, 2);
        int maxLength = 0, s = 0;
        input.sort(null);
        for (i = 0; i < input.size() - 1; i++) {
            if (input.get(i + 1) - input.get(i) != 1) {
                if (maxLength < (i - s))
                    maxLength = (i - s);
                s = i;
            }
        }
        if (input.get(i) - input.get(i - 1) == 1)
            if (maxLength < (i - s))
                maxLength = (i - s);

        System.out.println(maxLength);

    }

    private static List<Integer> getSubList(List<Integer> input, int target) {
        int n = input.size(), p1 = 0;
        int sum = 0, minSize = n + 1;
        int minStart = -1, minEnd = -1;
        for (int p2 = 0; p2 < n; p2++) {
            sum += input.get(p2);

            while (sum >= target) {
                if (p2 - p1 + 1 < minSize) {
                    minSize = p2 - p1 + 1;
                    minStart = p1;
                    minEnd = p2;
                }
                sum -= input.get(p1);
                p1++;
            }
        }

        if (minStart == -1)
            return new ArrayList<>();
        return input.subList(minStart, minEnd + 1);

    }

    private static List<List<Integer>> giveCombination(List<Integer> input, int position) {
        List<List<Integer>> output = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            output.add(new ArrayList<>());
        } else if (position == 0) {
            output.add(new ArrayList<>());
            output.add(new ArrayList<>(Collections.singletonList(input.get(position))));
        } else {
            output = giveCombination(input, position - 1);
            List<List<Integer>> tempOutput = output.stream()
                    .map(x -> {
                        List<Integer> list = new ArrayList<>(x);
                        list.add(input.get(position));
                        return list;
                    })
                    .collect(Collectors.toList());
            output.addAll(tempOutput);
        }
        return output;
    }

    private static List<List<Integer>> giveCombMask(List<Integer> input) {
        int length = input.size();
        int totalComb = 1 << length;
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < totalComb; i++) {
            List<Integer> ele = new ArrayList<>(totalComb);
            for (int j = 0; j < length; j++) {
                if (((i >> j) & 1) == 1)
                    ele.add(input.get(j));
            }
            output.add(ele);
        }
        return output;
    }

    private static List<List<Integer>> getTargetPairs(List<Integer> input, int target) {
        List<List<Integer>> output = new ArrayList<>();
        input.sort(null);
        int low = 0, high = input.size() - 1;
        while (low <= high) {
            int sum = input.get(low) + input.get(high);
            if (sum == target) {
                output.add(List.of(input.get(low), input.get(high)));
                low++;
                high--;
                while (input.get(low) == input.get(low - 1))
                    low++;
                while (input.get(high) == input.get(high + 1))
                    high--;
            } else if (sum > target)
                high--;
            else
                low++;
        }
        return output;
    }

    private static List<List<Integer>> getTargetPairsMap(List<Integer> input, int target) {
        List<List<Integer>> output = new ArrayList<>();
        Map<Integer, Boolean> mp = new HashMap<>();
        for (int num : input) {
            int comp = target - num;
            if (mp.getOrDefault(comp, false)) {
                output.add(List.of(num, comp));
                mp.put(comp, false);
            } else
                mp.put(num, true);
        }
        return output;
    }

    @Override
    public void runCode() {
        ArrayListPractice.main(null);
    }

}
