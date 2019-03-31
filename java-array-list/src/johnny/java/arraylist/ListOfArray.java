package johnny.java.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfArray {
    public static void main(String[] args) {
        // List of String arrays
        List<String[]> list = new ArrayList<>();

        String[] arr1 = { "a", "b", "c" };
        String[] arr2 = { "1", "2", "3", "4" };
        list.add(arr1);
        list.add(arr2);
        // printing list of String arrays in the ArrayList
        for (String[] strArr : list) {
            System.out.println(Arrays.toString(strArr));
        }
    }
}

/*
[a, b, c]
[1, 2, 3, 4]
 */