package johnny.java.core.set;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {

        constructHashSet();
        commonOperations();
        traverseSet();
        //wrongWayToRemoveElement();
        correctWayToRemoveElement();
        simpleUsage();
    }

    private static void constructHashSet() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        System.out.println("Construct set: " + set1);

        // initial capacity should be power of 2
        Set<Integer> set2 = new HashSet<>(32);

        // setting backing HashSet initial capacity and load factor
        Set<Integer> set3 = new HashSet<>(32, 0.80f);

        // creating HashSet from another Collection
        Set<Integer> set4 = new HashSet<>(Arrays.asList(new Integer[]{1,2,3,4,5,6,7}));
        System.out.println("Construct set with list: " + set4);
        Set<Integer> set5 = new HashSet<>(set1);
        System.out.println("Construct set with another set: " + set5);
    }

    private static void commonOperations() {
        // add
        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            set1.add(i);
        }
        System.out.println("Common operations - add : " + set1);

        // check existence
        System.out.println("Check whether element 3 exists : " + set1.contains(3));

        // remove
        set1.remove(6);
        System.out.println("Remove element 6 : " + set1);
    }

    private static void traverseSet() {
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        // for each
        for (String fruit : fruits) {
            System.out.println("Traverse Set(for each): processing - " + fruit);
        }

        System.out.println();

        // iterator
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Traverse Set(iterator): processing - " + fruit);
        }
    }

    private static void wrongWayToRemoveElement() {
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Mango");

        // in for each loop
        for (String fruit : fruits) {
            System.out.println("Traverse Set(for each): processing - " + fruit);

            if ("Orange".equals(fruit)) {
                fruits.remove("Orange");  // java.util.ConcurrentModificationException is thrown
            }
        }

        // in iterator loop
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println("Traverse Set(iterator): processing - " + fruit);

            if("Orange".equals(fruit)) {
                fruits.remove("Orange");  // java.util.ConcurrentModificationException is thrown
            }
        }

        System.out.println("fruits set after iteration = " + fruits);
    }

    private static void correctWayToRemoveElement() {
        Set<String> fruits = new HashSet<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Mango");

        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println("Remove element: processing - " + fruit);

            if("Orange".equals(fruit)) {
                iterator.remove(); // iterator.remove not set.remove
            }
        }

        System.out.println("fruits set after iteration = " + fruits);
    }

    private static void simpleUsage() {
        // Constructors
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>(32);
        Set<String> set3 = new HashSet<>(32, 0.80f);
        Set<String> set4 = new HashSet<>(new ArrayList<>());
        Set<String> set5 = new HashSet<>(new HashSet<>());

        // Add
        Set<Integer> set6 = new HashSet<>();
        for (int i = 0; i < 6; i++) {
            set6.add(i);
        }

        // Check exist
        boolean exists = set6.contains(3); // true
        // Remove
        set6.remove(2);                 // set6 = {0,1,3,4,5}
        // Size
        int size = set6.size();            // size = 5
    }
}
