package johnny.java.collection;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {

        constructList();

        commonOperations();

        sortList();

        traverseList();

        //wrongWayToRemoveElement();

        correctWayToRemoveElement();

        interfaces();

        simpleUsage();

        stream();
    }

    private static void constructList() {
        // no arguments
        List<Integer> list1 = new LinkedList<>();
        list1.add(5);
        list1.add(9);
        list1.add(4);
        list1.add(4);
        list1.add(2);
        System.out.println("Construct list: " + list1);

        // with another list
        List<Integer> list2 = new LinkedList<>(list1);
        System.out.println("Construct list with another list: " + list2);

        // with treeset
        SortedSet<Integer> treeSet1 = new TreeSet<>(list1);
        List<Integer> list3 = new LinkedList<>(treeSet1);
        System.out.println("Construct list with tree set: " + list3);
    }

    private static void commonOperations() {
        // add
        List<Integer> list1 = new LinkedList<>();
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

        // sub list
        List<Integer> list2 = list1.subList(2, 4);
        System.out.println("Sub list from index 2(inclusive) to index 4(exclusive) : " + list2);
    }

    private static void sortList() {
        // Sorting
        List<Integer> list1 = new LinkedList<>();
        list1.add(3);
        list1.add(1);
        list1.add(2);

        Collections.sort(list1);                // ascending order, list1 = {1,2,3}
        System.out.println("Sort list in ascending order: " + list1);
        Collections.sort(list1, (a,b)->(b-a));  // descending order, list1 = {3,2,1}
        System.out.println("Sort list in descending order: " + list1);
    }

    private static void traverseList() {
        List<String> fruits = new LinkedList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Watermelon");
        fruits.add("Kiwi");

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
        List<String> fruits = new LinkedList<>();
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
        List<String> fruits = new LinkedList<>();
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

    private static void interfaces() {
        // List Interface, insertion order
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.forEach(System.out::println);  // print 1,2,4

        // Queue interface, FIFO
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());  // print 1,2,3
        }

        // Deque interface, FIFO or LIFO
        Deque<Integer> deque = new LinkedList<>();
        deque.offerLast(1);  // deque = {1}
        deque.offerLast(2);  // deque = {1,2}
        deque.offerFirst(3); // deque = {3, 1, 2}
        deque.peekFirst();      // return 3
        deque.peekLast( );      // return 2
        deque.pollFirst();      // return 3, deque = {1,2}
        deque.pollLast();       // return 2, deque = {1}
    }

    private static void simpleUsage() {
        // Constructors
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>(new LinkedList<>());
        List<Integer> list3 = new LinkedList<>(new TreeSet<>());

        // Different interfaces
        List<Integer> list4 = new LinkedList<>();
        Queue<Integer> list5 = new LinkedList<>();
        Deque<Integer> list6 = new LinkedList<>();

        // Common operations
        /*
        list.add(item);
        list.add(0, item);
        list.remove(index);
        list.subList(index1, index2);
        */
        List<Integer> list7 = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            list7.add(i);
        }
        list7.add(0, 9);
        list7.remove(0);
        List<Integer> list8 = list7.subList(1,4); // list8 = {1,2,3}

        // Sorting
        Collections.sort(list7);                // list7 = {0,1,2,3,4,5}
        Collections.sort(list7, (a,b)->(b-a));  // list7 = {5,4,3,2,1,0}

    }

    private static void stream() {
        // LinkedList to Stream in Java 8
        List<String> list1 = new LinkedList<>();
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
