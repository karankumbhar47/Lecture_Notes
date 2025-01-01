package com.coreJava.RunnerClasses.Advance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.models.Student;

public class StreamPractice implements CodeRunnerInterface {

	@Override
	public void runCode() {
		// StreamPractice.main(new String[] {});
		StreamPractice.practice();
	}

	public static void main(String[] arg) {
		System.out.println("running method");
		// creating stream
		List<Integer> integers = Arrays.asList(1, 299, 23, 4, 56, 2, -3);
		// first way
		Stream<Integer> integerStream = integers.stream();

		// second way
		integerStream = Stream.of(1, 2, 1, 5, 5, 3, 2, 1);

		String[] strings = new String[] { "hello", "world", "This", "is", "random", "list" };
		Stream<String> stringStream = Arrays.stream(strings);
		stringStream.peek(System.out::println);

		List<Integer> list = Stream
				.iterate(0, n -> n + 1)
				// .peek(System.out::println)
				.limit(100)
				// .peek(System.out::println)
				.skip(1)
				// .peek(System.out::println)
				.collect(Collectors.toList());

		Random random = new Random();
		AtomicInteger previousMarks = new AtomicInteger(4);
		// Map<Integer,Student> students = Stream
		List<Student> students = Stream
				.iterate(1, x -> x + 1)
				.limit(50)
				.skip(1)
				.map(i -> {
					Student student = new Student("Name_" + i, random.nextInt(50));
					student.setMarks(previousMarks.get());
					previousMarks.addAndGet(student.getRollNumber());
					return student;
				})
				.peek((i) -> System.out.println(i))
				// .collect(Collectors.toMap(
				// student -> student.getRollNumber(),
				// student -> student,
				// (oldStudent,newStudent) -> oldStudent
				// ));
				.distinct()
				.collect(Collectors.toList());

		// students.forEach((key,value) -> System.out.println(key+" :- "+value));
		students.forEach(student -> System.err.println(student));
		System.out.println("Finished method");
	}

	public static void practice() {
		// question 1
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		numbers = numbers.stream()
				.filter(x -> x % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(numbers);

		// question 3
		numbers = Arrays.asList(1, 3, 5, 7, 8, 9);
		Optional<Integer> evenInteger = numbers.stream()
				.filter(x -> (x & 1) == 0)
				.findFirst();
		System.out.println(evenInteger.orElse(-1));

		// question 4
		numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		int sum = numbers.stream()
				.filter(x -> (x & 1) == 1)
				.reduce(0, (a, b) -> a + b);

		sum = numbers.stream()
				.filter(x -> (x & 1) == 1)
				.mapToInt(Integer::intValue)
				.sum();
		System.out.println(sum);

		// question 5
		String[] strings = new String[] { "apple", "banana", "cherry" };
		List<Integer> lengths = Arrays.stream(strings)
				.map(x -> x.length())
				.collect(Collectors.toList());
		System.out.println(lengths);

		// question 6
		numbers = Arrays.asList(5, 15, 20, 8, 12, 7, 30);
		long count = numbers.stream()
				.filter(x -> x > 10)
				.count();
		System.out.println(count);

		// question 7
		int[] listNumbers = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int minNumber = Arrays.stream(listNumbers)
				.reduce(Integer.MAX_VALUE, (a, b) -> a < b ? a : b);
		int maxNumber = Arrays.stream(listNumbers)
				.reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
		System.out.println(minNumber + " " + maxNumber);

		// practice
		OptionalInt optionalMin = Arrays.stream(listNumbers).min();
		Optional<Integer> minOf = numbers.stream().min(Integer::compare);
		OptionalInt optionalMax = Arrays.stream(listNumbers).max();
		Optional<Integer> maxOf = numbers.stream().max(Integer::compare);
		System.out.println(optionalMin.orElse(Integer.MIN_VALUE) + " "
				+ optionalMax.orElse(Integer.MAX_VALUE));
		System.out.println(minOf.orElse(Integer.MIN_VALUE) + " "
				+ maxOf.orElse(Integer.MAX_VALUE));

		// question 8
		strings = new String[] { "apple", "banana", "cherry" };
		String joinString = Arrays.stream(strings)
				.collect(Collectors.joining(",", "pre-", "-post"));
		System.out.println(joinString);

		// question 9
		numbers = Arrays.asList(4, 5, 7, 9, 11);
		boolean isTrue = numbers.stream()
				.anyMatch(x -> (x % 3) == 0);
		System.out.println(isTrue);

		// question 10
		numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 5, 6);
		numbers = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println(numbers);

		// question 11
		List<String> stringsList = numbers.stream()
				.map(String::valueOf)
				.collect(Collectors.toList());
		System.out.println(stringsList);

		// question 12
		List<List<Integer>> nestedList = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4), Arrays.asList(5, 6));
		numbers = nestedList.stream()
				.flatMap(x -> x.stream())
				.collect(Collectors.toList());
		System.out.println(numbers);

		// question 13
		OptionalDouble avg = numbers.stream()
				.mapToInt(Integer::valueOf)
				.average();
		System.out.println(avg.orElse(0.0));

		// question 14
		numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		Map<Boolean, List<Integer>> mp = numbers.stream()
				.collect(Collectors.partitioningBy(x -> x % 2 == 0));
		System.out.println(mp);

		// question 15
		stringsList = Arrays.asList("apple", "banana", "cherry", "date");
		Optional<String> firstString = stringsList.stream()
				.filter(x -> x.length() > 5)
				.findFirst();
		System.out.println(firstString.orElse("No Such String"));

		// question 17
		stringsList = Arrays.asList("madam", "apple", "racecar", "level");
		System.out.println(stringsList);
		stringsList = stringsList.stream()
				.filter(x -> x.equals(new StringBuilder(x).reverse().toString()))
				.collect(Collectors.toList());
		System.out.println(stringsList);

		// question 18
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4, 5);
		List<Integer> mergeList = Stream
				.concat(list1.stream(), list2.stream())
				.collect(Collectors.toList());
		System.out.println(mergeList);

		// question 19
		stringsList = Arrays.asList("apple", "banana", "cherry", "date");
		Map<Integer, List<String>> mp1 = stringsList.stream()
				.collect(Collectors.groupingBy(x -> x.length()));
		System.out.println(mp1);

		// question 20
		stringsList = Arrays.asList("apple", "banana", "cherry", "date");
		String maxString = stringsList.stream()
				.reduce("", (a, b) -> a.length() >= b.length() ? a : b);

		Optional<String> opMaxString = stringsList.stream()
				.max(Comparator.comparingInt(String::length));

		opMaxString = stringsList.stream()
				.max((a, b) -> a.length() - b.length());
		System.out.println(maxString);
		System.out.println(opMaxString.orElse("Not Found"));

	}

	@SuppressWarnings("unused")
	private void demo() {
		// List<Integer> list1 = Arrays.asList(1, 2, 3);
		// List<Integer> list2 = Arrays.asList(4, 5, 6);

		// numbers = Arrays.asList(1, 2, 29, 3, -2, 3, 111, 0);
		// OptionalInt minNumber0 = numbers.stream()
		// .mapToInt(x -> Integer.valueOf(x))
		// .min();

		// Optional<Integer> minNumber1 = numbers.stream()
		// .min((a, b) -> a - b);
		// System.out.println(minNumber0.orElse(-1)==minNumber1.orElse(-1));

		// Optional<Integer> minNumber2 = numbers.stream().min((x,y) -> x.compareTo(y));
		// System.out.println(minNumber2.orElse(-1));
		// numbers.removeIf(x -> x == 5);
		// System.out.println(numbers);

		// Integer a = 2;
		// Float b = 2.4f;
		// Comparator<Number> comp = new Comparator<Number>() {
		// @Override
		// public int compare(Number arg0, Number arg1) {
		// Double diff = arg0.doubleValue() - arg1.doubleValue();
		// return diff < 0 ? -1 : diff==0 ? 0 : 1;
		// }
		// };

		// System.out.println(comp.compare(a, b));
		// System.out.println(comp.compare(a, -1));
		// System.out.println(comp.compare(a, -1.323));
		// System.out.println(comp.compare(a, -1.323f));
		// System.out.println(comp.compare(a, -1.323d));

		// System.setProperty("joinString", "123");
		// System.setProperty("nothing", "something");
		// Number number = Integer.getInteger("joinString", 7);
		// String strProp = System.getProperty("nothing", "hello");
		// System.out.println(strProp);
		// strProp = System.getProperty("joinString", "hello");
		// System.out.println(strProp);
		// System.out.println(number);
	}

}