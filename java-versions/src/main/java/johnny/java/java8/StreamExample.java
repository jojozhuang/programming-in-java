package johnny.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        // Create list
        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            myList.add(i);
        }

        // sequential stream
        Stream<Integer> sequentialStream = myList.stream();
        // using lambda with Stream API, filter example
        Stream<Integer> seqFilter = sequentialStream.filter(p -> p > 90);
        // using lambda in forEach
        seqFilter.forEach(s -> System.out.println("Filter with sequential stream =" + s));

        // parallel stream
        Stream<Integer> parallelStream = myList.parallelStream();
        // using lambda with Stream API, filter example
        Stream<Integer> parFilter = parallelStream.filter(p -> p > 90);
        // using lambda in forEach
        parFilter.forEach(p -> System.out.println("Filter with parallel stream = " + p));

        // Notice that parallel processing values are not in order. Parallel processing will be very helpful while working with huge collections.

    }

}
