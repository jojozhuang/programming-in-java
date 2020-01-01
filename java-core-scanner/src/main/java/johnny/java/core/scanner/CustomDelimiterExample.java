package johnny.java.core.scanner;

import java.util.Scanner;

public class CustomDelimiterExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Testing custom delimiter, input string:");

        // change the delimiter of this scanner
        scan.useDelimiter(",");

        String s = "";
        while (scan.hasNext()) {
            s += scan.next() + "-";
        }
        // CMD + D on Mac to supply EOF for testing in terminal
        System.out.println("String: " + s);
    }
}
