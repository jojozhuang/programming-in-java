package johnny.java.core.basic;

import java.text.SimpleDateFormat;
import java.util.*;

public class LoopExample {
    public static void main(String[] args)
    {
        forLoop();
        //whileLoop();
        doWhileLoop();
    }

    private static void forLoop() {
        System.out.println("for loop examples:");

        // print integers 6 to 10
        for (int i = 6; i <= 10; i++) {
            System.out.println("Java for loop example - " + i);
        }

        // print integers with 'for each'
        int[] intArray = { 1, 2, 3, 4, 5 };

        for (int i : intArray) {
            System.out.println("Java for each example - " + i);
        }

        // print strings with 'for loop'
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        for (String f : fruits) {
            System.out.println("Java for each loop with collection - " + f);
        }

        // for loop with label, continue
        int[][] intArr = {{ 1, -2, 3 }, { 0, 3 }, { 9, 2, 5 }, { 1, 2, 5 }};

        process: for (int i = 0; i < intArr.length; i++) {
            boolean allPositive = true;
            for (int j = 0; j < intArr[i].length; j++) {
                if (intArr[i][j] < 0) {
                    allPositive = false;
                    continue process;
                }
            }
            if (allPositive) {
                // process the array
                System.out.println("Array has no negative elements: " + Arrays.toString(intArr[i]));
            }
        }

        // for loop with label, break
        search:
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                if (intArr[i][j] > 7) {
                    System.out.println("Find array which contains element larger than 7: " + Arrays.toString(intArr[i]));
                    break search;
                }
            }
        }
    }

    private static void whileLoop() {
        System.out.println("while loop examples:");

        // while loop
        int i = 6;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }

        // while loop with Iterator
        List<String> veggies = new ArrayList<>();
        veggies.add("Spinach");
        veggies.add("Potato");
        veggies.add("Tomato");

        Iterator<String> it = veggies.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }

        // infinite loop
        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
            Date current = new Date(System.currentTimeMillis());
            System.out.println(sdf.format(current));
        }
    }

    private static void doWhileLoop() {
        System.out.println("do while loop examples:");

        // do while loop
        int i = 6;
        do {
            System.out.println(i);
            i++;
        } while (i <= 10);

        // infinite loop
        do {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
            Date current = new Date(System.currentTimeMillis());
            System.out.println(sdf.format(current));
        } while(true);
    }
}
