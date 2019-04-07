package johnny.java.collection;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {

        constructList();

        commonOperations();

        sortList();

        traverseList();
        //wrongWayToRemoveElement();
        correctWayToRemoveElement();

        simpleUsage();

        stream();
    }

    private static void constructList() {
        // no arguments
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(9);
        list1.add(4);
        list1.add(2);
        System.out.println("Construct list: " + list1);

        // with another list
        List<Integer> list2 = new ArrayList<>(list1);
        System.out.println("Construct list with another list: " + list2);

        // with treeset
        SortedSet<Integer> treeSet1 = new TreeSet<>(list1);
        List<Integer> list3 = new ArrayList<>(treeSet1);
        System.out.println("Construct list with tree set: " + list3);
    }

    private static void commonOperations() {
        // add
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list1.add(i);
        }
        System.out.println("Common operations - add : " + list1);

        // insert
        list1.add(0, 12);
        System.out.println("Insert 12 at index 0 : " + list1);
        list1.add(5, 9);
        System.out.println("Insert 9 at index 5 : " + list1);

        // remove
        list1.remove(0);
        System.out.println("Remove element which is at index 0 : " + list1);

        // get
        System.out.println("Get element which is at index 3 : " + list1.get(3));

        // sub list
        List<Integer> list2 = list1.subList(2, 4);
        System.out.println("Sub list from index 2(inclusive) to index 4(exclusive) : " + list2);
    }

    private static void sortList() {
        // Sorting
        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(1);
        list1.add(2);
        Collections.sort(list1);                // ascending order, list1 = {1,2,3}
        System.out.println("Sort list in ascending order: " + list1);
        Collections.sort(list1, (a,b)->(b-a));  // descending order, list1 = {3,2,1}
        System.out.println("Sort list in descending order: " + list1);
    }

    private static void traverseList() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Kiwi");

        // basic for
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("Traverse List(basic for): processing - " + fruits.get(i));
        }

        System.out.println();

        // for each
        for (String fruit : fruits) {
            System.out.println("Traverse List(for each): processing - " + fruit);
        }

        System.out.println();

        // iterator
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Traverse List(iterator): processing - " + fruit);
        }
    }

    private static void wrongWayToRemoveElement() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Kiwi");

        // in for each loop
        for (String fruit : fruits) {
            System.out.println("Traverse List(for each): processing - " + fruit);

            if ("Orange".equals(fruit)) {
                fruits.remove("Orange");  // java.util.ConcurrentModificationException is thrown
            }
        }

        // in iterator loop
        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println("Traverse List(iterator): processing - " + fruit);

            if("Orange".equals(fruit)) {
                fruits.remove("Orange");  // java.util.ConcurrentModificationException is thrown
            }
        }

        System.out.println("fruits list after iteration = " + fruits);
    }

    private static void correctWayToRemoveElement() {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Kiwi");

        Iterator<String> iterator = fruits.iterator();

        while (iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println("Remove element: processing - " + fruit);

            if("Orange".equals(fruit)) {
                iterator.remove();  // iterator.remove not list.remove
            }
        }

        System.out.println("Fruits list after deletion = " + fruits);
    }

    private static void simpleUsage() {
        // Constructors
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>(1000);
        List<Integer> list3 = new ArrayList<>(new ArrayList<>());
        List<Integer> list4 = new ArrayList<>(new TreeSet<>());

        // Common operations
        /*
        list.add(item);
        list.add(0, item);
        list.remove(index);
        list.subList(index1, index2);
        */
        List<Integer> list5 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list5.add(i);
        }
        list5.add(0, 9);
        list5.remove(0);
        List<Integer> list6 = list5.subList(1,4); // list6 = {1,2,3}

        // Sorting
        Collections.sort(list5);                // list5 = {0,1,2,3,4,5}
        Collections.sort(list5, (a,b)->(b-a));  // list5 = {5,4,3,2,1,0}
    }

    private static void stream() {
        List<String> list1 = new ArrayList<>();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("e");

        //convert List to stream
        System.out.println("Steam - forEach");
        list1.stream().forEach(System.out::println);
    }
}
