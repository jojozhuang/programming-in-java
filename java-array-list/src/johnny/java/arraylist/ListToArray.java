package johnny.java.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        String[] arr1 = list.toArray(new String[list.size()]);
        System.out.println("arr1 = " + Arrays.toString(arr1));

        String[] arr2 = list.toArray(new String[0]);
        System.out.println("arr2 = " + Arrays.toString(arr2));

        String[] arr3 = list.stream().toArray(String[]::new);
        System.out.println("arr3 = " + Arrays.toString(arr3));
    }
}
