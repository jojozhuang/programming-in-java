package johnny.java.core.scanner;

import java.util.Scanner;

public class ScannerExample {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // String input
        System.out.println("Enter name:");
        String name = scan.nextLine();
        System.out.println("Your name is: " + name);

        // Int input
        System.out.println("Enter age:");
        int age = scan.nextInt();
        System.out.println("Your age is: " + age);

        // Double input
        System.out.println("Enter salary:");
        double salary = scan.nextDouble();
        System.out.println("Your salary is: " + salary);
    }
}
