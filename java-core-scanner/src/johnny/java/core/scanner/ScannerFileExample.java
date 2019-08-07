package johnny.java.core.scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerFileExample {
    private static final String INPUT_FILE = "input.txt";
    private static final String OUTPUT_FILE = "output.txt";

    public static void main(String args[]) throws Exception {
        String currentDir = System.getProperty("user.dir");

        List<OrderItem> items = new ArrayList<>();
        // Set system.io
        Path path = Paths.get(currentDir, "java-core-scanner", "files", INPUT_FILE);
        File file = path.toFile();
        System.setIn(new FileInputStream(file));

        // Get items from file
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            items.add(new OrderItem(sc.next(), sc.nextDouble(), sc.nextInt()));
        }
        sc.close();

        // Set system.out
        Path output = Paths.get(currentDir, "java-core-scanner", "files", OUTPUT_FILE);
        File outputFile = output.toFile();
        System.setOut(new PrintStream(outputFile));

        // Calculate the cost
        for (OrderItem item : items) {
            System.out.print(item.name + ": ");
            System.out.println(item.price * item.quantity);
        }
    }
}