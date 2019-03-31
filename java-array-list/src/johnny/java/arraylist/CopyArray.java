package johnny.java.arraylist;

import java.util.Arrays;

public class CopyArray {
    public static void main(String[] args) {
        int[] original = {1,2,3,4,5,6,7,8,9};

        System.out.println("Original array = " + Arrays.toString(original));

        int[] copy = Arrays.copyOf(original, original.length);
        System.out.println("Copy of array = " + Arrays.toString(copy));

        int[] copyRange = Arrays.copyOfRange(original, 3, 6);
        System.out.println("Range copy of array = " + Arrays.toString(copyRange));

        int[] systemCopy = new int[original.length];
        System.arraycopy(original, 0, systemCopy, 0, original.length);
        System.out.println("System copy of array = " + Arrays.toString(systemCopy));

        int[] clone = original.clone();
        System.out.println("Clone of array = " + Arrays.toString(clone));
    }
}
