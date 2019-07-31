package johnny.java.core.generics;

public class GenericMethodsExample {
    public static void main(String args[]) {
        // Create arrays of Integer, Double and Character
        Integer[] intArray = { 1, 2, 3, 4, 5 };
        Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
        Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };

        System.out.print("Array integerArray contains: ");
        printArray(intArray);   // pass an Integer array

        System.out.print("\nArray doubleArray contains: ");
        printArray(doubleArray);   // pass a Double array

        System.out.print("\nArray characterArray contains: ");
        printArray(charArray);   // pass a Character array
    }

    // generic method printArray
    public static < E > void printArray( E[] inputArray ) {
        // Display array elements
        for(E element : inputArray) {
            System.out.format("%s, ", element);
        }
    }

}
