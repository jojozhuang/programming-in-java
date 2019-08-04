package johnny.java8.newfeatures.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String args[]) {

        generateStream();
        streamMethods();
        pipeline();
        collectors();
        statistics();
    }

    private static void generateStream() {
        List<String> names = Arrays.asList("Johnny", "", "Peter", "Sean", "", "George");
        List<String> filtered = names.stream().filter(name -> !name.isEmpty()).collect(Collectors.toList());
        List<String> filtered2 = names.parallelStream().filter(name -> !name.isEmpty()).collect(Collectors.toList());
        System.out.println(names);
        System.out.println(filtered);
        System.out.println(filtered2);
    }

    private static void streamMethods() {
        List<Integer> nums = Arrays.asList(3, 7, 1, 8, 2, 4, 9, 5, 6);

        // forEach
        System.out.println("forEach");
        nums.stream().forEach(System.out::println);

        List<Integer> result;

        // map
        System.out.print("map:    ");
        result = nums.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(result);

        // filter
        System.out.print("filter: ");
        result = nums.stream().filter(i -> i > 4).collect(Collectors.toList());
        System.out.println(result);

        // limit
        System.out.print("limit:  ");
        result = nums.stream().limit(3).collect(Collectors.toList());
        System.out.println(result);

        // sorted
        System.out.print("sorted: ");
        result = nums.stream().sorted().collect(Collectors.toList());
        System.out.println(result);
    }

    private static void pipeline() {
        // pipelining
        List<Integer> nums = Arrays.asList(3, 7, 1, 8, 2, 9, 5, 6);
        System.out.print("pipelining: ");
        List<Integer> result = nums.stream().sorted().filter(i -> i > 4).limit(3).map(i->i*i).collect(Collectors.toList());
        System.out.println(result);

        // sorted:  [1,2,3,4,5,6,7,8,9]
        // filter:  [5,6,7,8,9]
        // limit:   [5,6,7]
        // map:     [25,36,49]
        // forEach: [25,36,49]
    }

    private static void collectors() {
        List<String> names = Arrays.asList("Johnny", "", "Peter", "Sean", "", "George");

        List<String> filtered = names.stream().filter(name -> !name.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        // convert list to string with common as delimiter
        String merged = names.stream().filter(name -> !name.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + merged);
    }

    private static void statistics() {
        List<Integer> nums = Arrays.asList(3, 7, 1, 8, 2, 9, 5, 6);

        IntSummaryStatistics stats = nums.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Maximum number in List : " + stats.getMax());
        System.out.println("Minimum number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}
