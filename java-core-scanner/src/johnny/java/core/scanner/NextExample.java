package johnny.java.core.scanner;

import java.util.Scanner;

public class NextExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Testing hasNext and next, input string:");

        String s = "";
        while (scan.hasNext()) {
            String next = scan.next();
            if (next.equals("quit")) {
                break;
            }
            s += next + "-";
        }
        // Input 'quit' to stop the input
        System.out.println("String: " + s);
    }
}
