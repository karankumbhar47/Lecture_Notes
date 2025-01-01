package com.coreJava.RunnerClasses;

import com.coreJava.FactoryPattern.CodeRunnerInterface;
import com.coreJava.models.Student;
import com.coreJava.models.StudentObject;

import java.util.Arrays;
import java.util.Objects;

public class ObjectMethods implements CodeRunnerInterface {
    /*
     * thumb rule
     * 1. "==" --> sign always checks reference of the objects
     * if the datatypes are primitive then check
     * values
     * 2. "default equals method" --> by default, check reference again,
     * but we can change it to value my modifying it
     * by default it is behaved like a "==" operator
     * 3. "default hashCode method" --> implementation of hashcode gives hash
     * of memory address of the object. Not include other attributes in
     * hash.
     */
    public static void main(String[] args) {

        System.out.println("Integer caching");
        Integer num1 = Integer.valueOf(10);
        Integer num2 = Integer.valueOf(10);
        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));

        System.out.println("Separate Integer Objects");
        Integer num3 = Integer.valueOf(1000);
        Integer num4 = Integer.valueOf(1000);
        System.out.println(num3 == num4);
        System.out.println(num3.equals(num4));

        System.out.println("String caching");
        String str1 = "hello";
        String str2 = "hello";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println("Separate String object");
        String str3 = new String("hello");
        String str4 = new String("hello");
        System.out.println(str3 == str4);
        System.out.println(str3.equals(str4));

        System.out.println("Separate Array Objects");
        int arr1[] = { 1, 2, 3, 4, 5 };
        int arr2[] = { 1, 2, 3, 4, 5 };
        System.out.println(arr1 == arr2);
        System.out.println(arr1.equals(arr2));
        System.out.println(Arrays.equals(arr1, arr2));

        System.out.println("Separate Student object");
        StudentObject a = new StudentObject("karan", 12);
        StudentObject b = new StudentObject("karan", 12);
        System.out.println(a == b);
        System.out.println(a.equals(b));

        /*
         * shallow copy (both variables point to same object reference)
         * here only create different reference but pointing to same attributes
         * of previous one
         * deep copy (copy all attributes in new object create a new object with
         * different reference)
         */

        System.out.println("array copy");
        int arr3[] = arr1; // (here we have two variables pointing to same address/reference)
        int arr4[] = arr1.clone(); // here we have separate reference for arr1
        System.out.println(arr1 + " " + arr2 + " " + arr3 + " " + arr4);

        System.out.println("arr1 -> arr2 (deep copy)");
        System.out.println(arr1 == arr2);
        System.out.println(arr1.equals(arr2));
        System.out.println(Arrays.equals(arr1, arr2));

        System.out.println("arr1 -> arr3 (assignment)");
        System.out.println(arr1 == arr3);
        System.out.println(arr1.equals(arr3));
        System.out.println(Arrays.equals(arr1, arr3));

        System.out.println("arr1 -> arr4 (shallow copy)");
        System.out.println(arr1 == arr4);
        System.out.println(arr1.equals(arr4));
        System.out.println(Arrays.equals(arr1, arr4));

        // to string method (to string will add className @ hashCode)
        String[] strArr = { "hello", "dear" };
        System.out.println(strArr);

        double[] doubleArr = { 1, 2, 2, 3 };
        System.out.println(doubleArr.toString());

        float[] floatArr = { 1, 2, 2, 3 };
        System.out.println(floatArr.toString());

        // we have to write hashCode and equals method at a time
        // to preserve contract as
        // equality ==> hash equality (contract)
        // hash equality !=> equality
    }

    @Override
    public void runCode() {
        ObjectMethods.main(null);
    }
}
