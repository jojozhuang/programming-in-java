package johnny.java.core.basic;

public class CharSequenceExample {
    public static void main(String[] args)
    {
        // CharSequence creation, instantiated by implementation class(String, StringBuffer or  StringBuilder)
        CharSequence string = "hello, String!";
        CharSequence stringbuffer = new StringBuffer("hello, StringBuffer!");
        CharSequence stringbuilder = new StringBuilder("hello, StringBuilder!");
        System.out.println(string);
        System.out.println(stringbuffer);
        System.out.println(stringbuilder);

        // Comparison
        CharSequence cs1 = "java";                      // created by String, fetched from String Pool
        String str1 = "java";                           // fetched from String Pool
        StringBuilder sb1 = new StringBuilder("java");
        StringBuffer sb2 = new StringBuffer("java");
        System.out.println(cs1 == str1);                // true, since they are both from String Pool
        System.out.println(cs1.equals(str1));           // true, their values are same
        System.out.println(cs1.equals(sb1));            // false
        System.out.println(cs1.equals(sb1.toString())); // true
        System.out.println(cs1.equals(sb2));            // false
        System.out.println(cs1.equals(sb2.toString())); // true

        CharSequence cs2 = new String("java");  // new string object, not in String Pool
        System.out.println(cs2 == str1);                // false
        System.out.println(cs2.equals(str1));           // true

    }
}
