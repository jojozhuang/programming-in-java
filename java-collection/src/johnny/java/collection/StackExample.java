package johnny.java.collection;

import java.util.Stack;

public class StackExample {
    public static void main(String a[]){
        Stack<Integer> stack = new Stack<>();
        System.out.println("stack : "  + stack); // []
        System.out.println("Empty stack : "  + stack.isEmpty()); // true
        // Exception in thread "main" java.util.EmptyStackException
        // System.out.println("Empty stack : Pop Operation : "  + stack.pop());
        stack.push(11);
        stack.push(12);
        stack.push(13);
        stack.push(14);
        System.out.println("stack : "  + stack); // [11,12,13,14]
        System.out.println("Pop Operation : "  + stack.pop()); // 14
        System.out.println("After Pop Operation : "  + stack); // [11,12,13]
        System.out.println("search() Operation : "  + stack.search(12)); // 2
        System.out.println("stack : "  + stack.isEmpty()); // false
    }
}
