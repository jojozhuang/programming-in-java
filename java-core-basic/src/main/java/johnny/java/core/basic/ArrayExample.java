package johnny.java.core.basic;

import java.util.Arrays;

public class ArrayExample {
    public static void main(String[] args) {
        // create empty array
        int[] nums1 = new int[]{};
        String[] strs1 = new String[]{};

        // create array with length = 3
        int[] nums2 = new int[3];
        String[] strs2 = new String[3];

        // create char array from string
        String s = "hello";
        char[] chs = s.toCharArray(); // chs = {'h','e','l','l','o'};

        // for loop
        for (int i = 0; i < nums2.length; i++) {
            int num = nums2[i];
        }
        // or, for each loop
        for (int num : nums2) {

        }

        // Sort array
        int[] nums = {3, 7, 6, 5, 9, 2};
        Arrays.sort(nums);  // nums = {2,3,5,6,7,9};

        // Binary search on sorted array or collection
        int index1 = Arrays.binarySearch(new char[]{'c','d','e','f','g'}, 'f');  // index1 = 3;
        int index2 = Arrays.binarySearch(new int[]{10,15,20,22,35}, 20); // index2 = 2;

        // Binary search on array
        int[] array = {10,15,20,22,35};
        int index3 = Arrays.binarySearch(array,20); // index3 = 2
        int index4 = Arrays.binarySearch(array,8);  // index4 = -1, (-insertion point) - 1
        int index5 = Arrays.binarySearch(array,40); // index5 = -6, (-insertion point) - 1

        // print Array
        int[] nums3 = {1,3,5,7};
        System.out.println(Arrays.toString(nums3)); // print [1,3,5,7]
    }
}
