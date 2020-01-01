package johnny.java8.newfeatures.functionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceExample {
    public static void main(String args[]) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        // Predicate<Integer> predicate = n -> true
        // n is passed as parameter to test method of Predicate interface
        // test method will always return true no matter what value n has.

        System.out.print("Print all numbers: ");

        //pass n as parameter
        evaluate(list, n->true);

        // Predicate<Integer> predicate1 = n -> n%2 == 0
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n%2 comes to be zero

        System.out.print("Print even numbers: ");
        //evaluate(list, n-> n%2 == 0 );
        evaluate(list, new evenPredicate());

        // Predicate<Integer> predicate2 = n -> n > 3
        // n is passed as parameter to test method of Predicate interface
        // test method will return true if n is greater than 3.

        System.out.print("Print numbers greater than 3: ");
        evaluate(list, n-> n > 3 );
    }

    public static void evaluate(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer num: list) {
            if (predicate.test(num)) {
                System.out.print(num + ",");
            }
        }
        System.out.println();
    }

    private static class evenPredicate implements Predicate<Integer> {
        @Override
        public boolean test(Integer num) {
            return num % 2 == 0;
        }
    }
}
