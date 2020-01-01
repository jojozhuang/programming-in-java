package johnny.java8.newfeatures.mtdref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MethodReferencesExample {
    public static void main(String args[]) {

        List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
        nums.forEach(System.out::println);

        Printer printer = System.out::println;
        printer.print();

        //List list = ArrayList<Integer>::new;

    }

    interface Printer {
        void print();
    }
}
