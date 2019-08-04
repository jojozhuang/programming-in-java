package johnny.java.core.set;

import java.util.*;

public class TreeSetExample {
    public static void main(String[] args) {

        constructTreeSet();
        commonOperations();
        traverseTreeSet();
        //wrongWayToRemoveElement();
        correctWayToRemoveElement();
        simpleUsage();
    }

    private static void constructTreeSet() {
        SortedSet<Integer> treeSet1 = new TreeSet<>();
        treeSet1.add(5);
        treeSet1.add(9);
        treeSet1.add(4);
        treeSet1.add(2);
        System.out.println("Construct TreeSet: " + treeSet1);

        // Comparator
        SortedSet<Integer> treeSet2 = new TreeSet<>((a,b)->b-a); // reverse order
        treeSet2.add(5);
        treeSet2.add(9);
        treeSet2.add(4);
        treeSet2.add(2);
        System.out.println("Construct TreeSet with comparator: " + treeSet2);

        // with another Collection
        List<Integer> list = Arrays.asList(7,2,1,4,6,5);
        SortedSet<Integer> treeSet3 = new TreeSet<>(list);
        System.out.println("Construct TreeSet with list: " + treeSet3);

        // with another TreeSet
        SortedSet<Integer> treeSet4 = new TreeSet<>(treeSet2);
        System.out.println("Construct TreeSet with another set: " + treeSet4);
    }

    private static void commonOperations() {
        // add
        TreeSet<Integer> treeSet1 = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            treeSet1.add(i);
        }
        System.out.println("Common operations - add : " + treeSet1);

        // check existence
        System.out.println("Check whether element 3 exists : " + treeSet1.contains(3));

        // lower and higher boundaries
        System.out.println("First element is: " + treeSet1.first());
        System.out.println("Last element is: " + treeSet1.last());
        System.out.println("Closest lower element than 4 is: "+ treeSet1.lower(4));
        System.out.println("Closest higher element than 4 is: "+ treeSet1.higher(4));
        System.out.println("Closest floor element than 5 is: "+ treeSet1.floor(5));
        System.out.println("Closest ceiling element than 4 is: " + treeSet1.ceiling(4));

        // poll first and last entries
        System.out.println("First element(Polled) is: " + treeSet1.pollFirst());
        System.out.println("Last element(Polled) is: " + treeSet1.pollLast());
        System.out.println("TreeMap after polling: " + treeSet1);

        // submap, headmap and tailmap
        Set<Integer> subSet = treeSet1.subSet(2, true, 6, true);
        System.out.println("SubSet from 2 to 6 is: " + subSet);
        System.out.println("HeadSet to 5: " + treeSet1.headSet(5, true));
        System.out.println("TailMap from 5: " + treeSet1.tailSet(5, true));

        // reverse
        Set<Integer> descendingSet = treeSet1.descendingSet();
        System.out.println("Descending set: " + descendingSet);

        // remove
        treeSet1.remove(6);
        System.out.println("Remove element 6 : " + treeSet1);
    }

    private static void traverseTreeSet() {
        Set<String> fruits = new TreeSet<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        // for each
        for (String fruit : fruits) {
            System.out.println("Traverse TreeSet(for each): processing - " + fruit);
        }

        System.out.println();

        // iterator
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Traverse TreeSet(iterator): processing - " + fruit);
        }
    }

    private static void wrongWayToRemoveElement() {
        Set<String> fruits = new TreeSet<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        // in for each loop
        for (String fruit : fruits) {
            System.out.println("Traverse TreeSet(for each): processing - " + fruit);

            if ("Orange".equals(fruit)) {
                fruits.remove("Orange");  // java.util.ConcurrentModificationException is thrown
            }
        }

        // in iterator loop
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println("Traverse TreeSet(iterator): processing - " + fruit);

            if("Orange".equals(fruit)) {
                fruits.remove("Orange");  // java.util.ConcurrentModificationException is thrown
            }
        }

        System.out.println("fruits set after iteration = " + fruits);
    }

    private static void correctWayToRemoveElement() {
        Set<String> fruits = new TreeSet<>();
        fruits.add("Banana");
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Mango");

        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println("Remove element: processing - " + fruit);

            if ("Orange".equals(fruit)) {
                iterator.remove(); // iterator.remove not set.remove
            }
        }

        System.out.println("fruits set after remove = " + fruits);
    }

    private static void simpleUsage() {
        // Constructors
        SortedSet<Integer> treeSet1 = new TreeSet<>();
        SortedSet<Integer> treeSet2 = new TreeSet<>((a,b)->b-a);
        SortedSet<Integer> treeSet3 = new TreeSet<>(new ArrayList<>());
        SortedSet<Integer> treeSet4 = new TreeSet<>(new TreeSet<>());

        // Add
        SortedSet<Integer> treeSet5 = new TreeSet<>();
        for (int i = 0; i < 6; i++) {
            treeSet5.add(i);
        }

        // Check exist
        boolean exists = treeSet5.contains(3); // true
        // Remove
        treeSet5.remove(2);                 // treeSet5 = {0,1,3,4,5}
        // Size
        int size = treeSet5.size();            // size = 5
    }
}
