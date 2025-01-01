package com.coreJava.RunnerClasses.Advance;

import com.coreJava.FactoryPattern.CodeRunnerInterface;

public class EqualityPractice implements CodeRunnerInterface {

    @Override
    public void runCode() {
        EqualityPractice.main(null);
    }

    public static void main(String[] args) {
        // these are string literals saved in same address
        // so their references also same
        String str1 = "Hello";
        String str2 = "Hello";

        String str3 = "Hello Again";

        // function equals check content equality
        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));

        // == sign check reference equality
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);

        // created in different places
        String str4 = new String("hello");
        String str5 = new String("hello");
        System.out.println(str4.equals(str5));
        System.out.println(str4 == str5);

        Integer num1 = 1000;
        Integer num2 = 1000;

        System.out.println(num1 == num2);
        System.out.println(num1.equals(num2));

        Integer num3 = Integer.valueOf(1000);
        Integer num4 = Integer.valueOf(1000);

        System.out.println(num4 == num3);
        System.out.println(num4.equals(num3));

        // no references are available for the
        // primitive data type as they directly
        // store value at the address
        int num5 = 1245;
        int num6 = 1245;
        System.out.println(num5 == num6);
    }

}
