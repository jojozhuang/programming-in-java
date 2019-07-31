package johnny.java.core.generics.wildcards;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildcardsExample {
    public static void main(String args[]) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sum(integerList));

        List<Double> doubleList = Arrays.asList(1.1, 2.5, 3.8);
        System.out.println("sum = " + sum(doubleList));
    }

    public static double sum(List<? extends Number> nums) {
        double sum = 0.0;
        for (Number n : nums) {
            sum += n.doubleValue();
        }
        return sum;
    }

}
