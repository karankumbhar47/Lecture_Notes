package com.coreJava.RunnerClasses.Advance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.RunnerClasses.List.ListPractice.InnerClass;
import com.coreJava.models.Employee;
import com.coreJava.models.Student;

public class CollectionPractice implements CodeRunnerInterface {
    @Override
    public void runCode() {
        CollectionPractice.main(null);
    }

    public static <T> void main(String[] args) {
        // Arraylist capacity 10/ increasing factor 1.5

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Sandesh", 12, 33));
        studentList.add(null);
        studentList.add(new Student("Karan", 12, 33));
        studentList.add(new Student("Prakash", 18, 39));
        studentList.add(null);
        studentList.add(new Student("Aditya", 1, 30));
        studentList.add(new Student("Rahul", 22, 40));
        studentList.add(null);

        // Comparator<Student> comparator =
        // Comparator.comparingInt(Student::getRollNumber);
        // Comparator<Student> comparator2 =
        // Comparator.comparing(Student::getRollNumber).reversed().thenComparing(Student::getName).reversed();

        // studentList.sort(comparator);
        // studentList.forEach(System.out::println);
        // studentList.sort(comparator2);
        // System.out.println("\ncomparator 2\n");
        // studentList.forEach(System.out::println);

        // studentList.sort(Student::compareTo);
        // studentList.sort((arg0, arg1) -> {
        // if(arg0==null && arg1==null) return 0;
        // if(arg0==null) return 1;
        // if(arg1==null) return -1;
        // return arg0.compareTo(arg1);
        // });

        // studentList.sort(Comparator.nullsLast(Student::compareTo));
        // studentList.sort(Comparator.nullsLast(Comparator.comparing(Student::getRollNumber)));
        // studentList.sort(Comparator.nullsFirst(Comparator.comparing(Student::getRollNumber)));

        // Collections.sort(studentList,null);
        // studentList.sort((x,y) -> 1);
        // studentList.forEach(student -> System.out.println(student));
        // printSeparator();

        List<Employee> employees = Arrays.asList(
                new Employee("Charlie", "HR", 45000),
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 60000),
                new Employee("Dave", "Finance", 70000));

        // employees.sort(null);
        // Collections.sort(employees);
        // employees.sort((a,b) -> a.getDepartment().compareTo(b.getDepartment()));
        // employees.sort(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary));
        // employees.sort(Comparator.naturalOrder());
        // employees.forEach(x -> System.out.println(x));
        // printSeparator();
        // employees.sort(Comparator.reverseOrder());
        // employees.forEach(x -> System.out.println(x));

        // Comparator<Integer> comp = new Comparator<Integer>() {
        // @Override
        // public int compare(Integer a, Integer b) {
        // if (a % 2 == 0 && b % 2 == 0)
        // return a.compareTo(b);
        // if (a % 2 == 0)
        // return -1;
        // if (b % 2 == 0)
        // return 1;
        // else
        // return b.compareTo(a);
        // }
        // };

        // List<Integer> intergerList = Stream.iterate(0, x -> x + 1)
        // .limit(50)
        // .sorted(comp)
        // .collect(Collectors.toList());
        // System.out.println(intergerList);

        // List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 6, 3, 7, 4);
        // numbers = numbers.stream()
        // .sorted((a, b) -> {
        // if (a % 2 == 0 && b % 2 == 0)
        // return a.compareTo(b);
        // if (a % 2 == 0)
        // return -1;
        // if (b % 2 == 0)
        // return 1;
        // else
        // return b.compareTo(a);
        // })
        // .collect(Collectors.toList());
        // System.out.println(numbers);

        // List<Person> people = Arrays.asList(
        // new Person("Alice", "Brown", 30),
        // new Person("Alice", "Brown", 25),
        // new Person("Charlie", "Davis", 35),
        // new Person("Dave", "Brown", 25));
        // people.sort(Comparator.comparing(Person::getLastName)
        // .thenComparing(Person::getFirstName)
        // .thenComparing(Person::getAge));
        // people.forEach(x -> System.out.println(x));

        // System.out.println(numbers);
        // numbers.sort(Comparator.comparingInt(a -> a));
        // System.out.println(numbers);

        // Collections.sort(employees,null);
        // employees.forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(Integer.MAX_VALUE, 3, 8, 1, Integer.MIN_VALUE);
        numbers.sort((a, b) -> b.compareTo(a)); // Descending order
        System.out.println(numbers);

        InnerClass.nothing();

    }

    private static void printSeparator() {
        System.out.println("\n" + "=".repeat(50) + "\n");
    }
}
