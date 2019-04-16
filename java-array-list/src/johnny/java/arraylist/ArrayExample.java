package johnny.java.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayExample {
    public static void main(String[] args) {
        initializArray();
        arrayOfList();
        listOfArray();
    }

    private static void initializArray() {
        //initialize primitive one dimensional array
        int[] nums = new int[5];

        //initialize Object one dimensional array
        String[] strings; //declaration

        strings = new String[4]; //initialization

        //initialize multidimensional array
        int[][] matrix = new int[4][5];

        //multidimensional array initialization with only leftmost dimension
        int[][] array = new int[2][];
        array[0] = new int[2];
        array[1] = new int[3]; //complete initialization is required before we use the array

        //array initialization using shortcut syntax
        int[] nums1 = {1,2,3};
        int[][] nums2 = {{1,2}, {1,2,3}};

        //invalid because dimension is not provided
        // int[] a = new int[];

        //invalid because leftmost dimension value is not provided
        //int[][] aa = new int[][5];
    }

    private static void arrayOfList() {
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");

        List<String> list2 = new ArrayList<>();
        list2.add("3");
        list2.add("4");
        list2.add("5");

        //List<String>[] arrayOfList = new List<String>[2]; // Can’t use generics while creating the array because java doesn’t support generic array
        List<String>[] arrayOfList = new List[2];

        arrayOfList[0] = list1;
        arrayOfList[1] = list2;

        for (int i = 0; i < arrayOfList.length; i++) {
            List<String> list = arrayOfList[i];
            System.out.println(list);
        }
    }

    private static void listOfArray() {
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
