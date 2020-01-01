package johnny.java.core.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // create list
        List<Integer> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        // create list with array
        Integer[] nums = new Integer[]{1,2,3};
        List<Integer> list = Arrays.asList(nums); // list = {1,2,3}

        // Sort collection
        List<String> list3 = new ArrayList<String>();
        list3.add("orange");
        list3.add("apple");
        list3.add("banana");
        Collections.sort(list3); // list3 = {"apple", "banana", "orange"}

        // Binary search on collection
        List list4 = new ArrayList<>(Arrays.asList(new Integer[]{10,15,20,22,35}));
        int index1 = Collections.binarySearch(list4,20); // index1 = 2
        int index2 = Collections.binarySearch(list4,8);  // index2 = -1, (-insertion point) - 1
        int index3 = Collections.binarySearch(list4,40); // index3 = -6, (-insertion point) - 1
    }
}
