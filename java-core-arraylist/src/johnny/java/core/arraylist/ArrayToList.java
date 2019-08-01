package johnny.java.core.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        // approach one
        convertByArrays();

        System.out.println();

        // approach two
        convertByCollections();
    }

    private static void convertByArrays() {
        System.out.println("Convert array to list with Arrays.asList()");

        String[] strArr = {"a", "b", "c", "d"};
        System.out.println("Original array: " + Arrays.toString(strArr));

        // convert
        List<String> strList = Arrays.asList(strArr);
        System.out.println("Converted ArrayList: " + strList.toString());

        // change the array element
        strArr[0] = "z";
        System.out.println("Changed array: " + Arrays.toString(strArr));
        System.out.println("ArrayList after array is changed: " + strList.toString() + ", list is impacted.");
        // below code will throw java.lang.UnsupportedOperationException because
        // Arrays.asList() returns a fixed-size list backed by the specified array.
        //strList.add("5");
    }

    private static void convertByCollections() {
        System.out.println("Convert array to list with Collections.addAll()");

        String[] strArr = {"a", "b", "c", "d"};
        System.out.println("Original Array: " + Arrays.toString(strArr));

        // convert
        List<String> strList = new ArrayList<>();
        Collections.addAll(strList, strArr);
        System.out.println("Converted ArrayList: " + strList);

        // change the array element
        strArr[0] = "z";
        System.out.println("Changed array: " + Arrays.toString(strArr));
        System.out.println("ArrayList after array is changed: " + strList.toString() + ", list is not impacted.");

        // add new element to list
        strList.add("e");
        System.out.println("ArrayList after new element is added: " + strList.toString());
    }
}
