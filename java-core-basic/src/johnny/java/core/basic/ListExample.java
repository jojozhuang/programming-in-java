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
        int[] nums = new int[]{1,2,3};
        List<Integer> list = Arrays.asList(nums); // list = {1,2,3}

        // Sort collection
        List<String> list = new ArrayList<String>();
        list.add("orange");
        list.add("apple");
        list.add("banana");
        Collections.sort(list); // list = {"apple", "banana", "orange"}

        int index3 = Collections.binarySearch(Arrays.asList(new Integer[] {10,15,20,22,35}), 15); // index3 = 1;

        // Binary search on collection
        List list = new ArrayList<>(Arrays.asList(new Integer[]{10,20,15,22,35}));
        int index1 = Collections.binarySearch(list,20); // index1 = 2
        int index2 = Collections.binarySearch(list,8);  // index2 = -1, (-insertion point) - 1
        int index3 = Collections.binarySearch(list,40); // index3 = -6, (-insertion point) - 1
    }
}
