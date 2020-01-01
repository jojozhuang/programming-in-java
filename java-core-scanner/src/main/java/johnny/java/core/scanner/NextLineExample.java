package johnny.java.core.scanner;

import java.util.Scanner;

public class NextLineExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Testing hasNextLine and nextLine, input string:");

        String s = "";
        while (scan.hasNextLine()) {
            String nextline = scan.nextLine();
            if (nextline.equals("quit")) {
                break;
            }
            s += nextline + "-";
        }
        // Input 'quit' to stop the input
        System.out.println("String: " + s);
    }
}
