package johnny.java.core.basic;

import java.util.Arrays;

public class StringExample {
    public static void main(String[] args)
    {
        // String creation
        String s1 = "java";                                  // s1 = "java"
        String s2 = new String("java");              // s2 = "java"
        String s3 = new String(new char[]{'j','a','v','a'}); // s3 = "java", created by char array
        String s4 = String.valueOf(5);                       // s4 = "5", created by int

        // concatenate strings
        String s10 = "hello";
        String s11 = "123";
        String s12 = s10 + s11; // s12 = "hello123";

        // String comparison
        String str1 = "java";                                  // stored in String Pool
        String str2 = "java";                                  // stored in String Pool
        String str3 = new String("java");              // created locally, it is not in String Pool
        String str4 = new String(new char[]{'j','a','v','a'}); // s3 = "java"
        System.out.println(str1 == str2);                      // true, both are from String Pool, same object
        System.out.println(str1.equals(str2));                 // true
        System.out.println(str1 == str3);                      // false, str4 is created with new keyword
        System.out.println(str1.equals(str3));                 // true
        System.out.println(str1 == str4);                      // false, str4 is created with new keyword
        System.out.println(str1.equals(str4));                 // true

        // Substring
        String s = "hello, world";
        String substring = s.substring(0, 5);             // substring = "hello"
        System.out.println(substring);
        CharSequence subSequence = s.subSequence(0, 5);   // subSequence = "hello"
        System.out.println(subSequence);

        // Split string to string array
        String sentence = "I am a software engineer";
        String[] array = sentence.split(" ");      // array = {"I", "am", "a", "software", "engineer"}

        // Split string with regex
        String a = "1+2i";
        String[] x = a.split("\\+|i");             // x = {"1", "2"};
        System.out.println(Arrays.toString(x));

        String b = "1+2i3";
        String[] y = b.split("\\+|i");             // y = {"1", "2", "3"};
        System.out.println(Arrays.toString(y));

        // Replace string
        String strA = "hello, world";
        strA = strA.replaceAll("o","tt"); // strA = "helltt, wttld";
        System.out.println(strA);

        // Convert string to upper case
        String strB = "Hello, World!";
        strB = strB.toUpperCase();                       // strB = "HELLO, WORLD!"
        System.out.println(strB);

        // Convert string to lower case
        String strC = "Hello, World!";
        strC = strC.toLowerCase();                       // strC = "hello, world!"
        System.out.println(strC);

        // intern()
        String strAA = "intern";
        String strBB = new String("intern");
        System.out.println(strAA == strBB);                    // false, strBB is created with new keyword
        System.out.println(strAA.equals(strBB));               // true

        // get the string from String Poll
        String strCC = strBB.intern();                         // strCC is fetched from String Pool
        System.out.println(strAA == strCC);                    // true, strCC is strAA
        System.out.println(strAA.equals(strCC));               // true
    }
}
