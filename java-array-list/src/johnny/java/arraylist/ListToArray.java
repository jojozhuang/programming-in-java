package johnny.java.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArray {
    public static void main(String[] args) {
        usingObject();
        usingGeneric();
        usingStream();
    }

    private static void usingObject() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // List.toArray() method returns an array of type Object(Object[])
        Object[] objects = list.toArray();
        System.out.println("objects = " + Arrays.toString(objects));
    }

    private static void usingGeneric() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // 1. Create same type array with same size
        Integer[] arr1 = new Integer[list.size()];
        arr1 = list.toArray(arr1);
        System.out.println("arr1 = " + Arrays.toString(arr1));

        // Shortcut for above approach
        Integer[] arr2 = list.toArray(new Integer[list.size()]);
        System.out.println("arr2 = " + Arrays.toString(arr2));

        // 2. The given array has no enough space, a new array is created
        Integer[] arr3 = list.toArray(new Integer[0]);
        System.out.println("arr3 = " + Arrays.toString(arr3));

        // 3. The given array has more space, the right part are filled with null
        Integer[] arr4 = list.toArray(new Integer[10]);
        System.out.println("arr4 = " + Arrays.toString(arr4));
    }

    private static void usingStream() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Use stream in Java 8
        Integer[] arr5 = list.stream().toArray(Integer[]::new);
        System.out.println("arr5 = " + Arrays.toString(arr5));
    }

    private static void invalidExample() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // Error: incompatible types: Object[], cannot be converted to Integer[]
        //Integer[] arr1 = list.toArray();
        //System.out.println("arr1 = " + Arrays.toString(arr1));
    }
}
