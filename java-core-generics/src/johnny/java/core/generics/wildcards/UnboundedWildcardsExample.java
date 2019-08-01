package johnny.java.core.generics.wildcards;

import java.util.Arrays;
import java.util.List;

public class UnboundedWildcardsExample {
    public static void main(String args[]) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        printAll(integerList);
        List<Double> doubleList = Arrays.asList(1.1, 2.5, 3.8);
        printAll(doubleList);
    }

    public static void printAll(List<?> list) {
        for (Object item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
}
