package johnny.java.core.map;

import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {

        constructTreeMap();
        commonOperations();
        traverseTreeMap();
        //wrongWayToRemoveElement();
        correctWayToRemoveElement();
        simpleUsage();
    }

    private static void constructTreeMap() {
        SortedMap<String, String> treeMap1 = new TreeMap<>();
        treeMap1.put("A", "A"); // put example
        treeMap1.put("B", "B");
        treeMap1.put("C", "C");
        treeMap1.put("D", null); // null value
        //treeMap1.put(null, "Z"); // key can't be null
        System.out.println("Construct TreeMap: " + treeMap1);

        // Comparator
        SortedMap<String, String> treeMap2 = new TreeMap<>((a,b)->b.compareTo(a)); // reverse order
        treeMap2.put("A", "A");
        treeMap2.put("B", "B");
        treeMap2.put("C", "C");
        treeMap2.put("D", "D");
        System.out.println("Construct TreeMap with comparator: " + treeMap2);

        // with another map
        Map<String, String> map = new HashMap<>();
        map.put("B", "B");
        map.put("A", "A");
        map.put("D", "D");
        map.put("C", "C");

        SortedMap<String, String> treeMap3 = new TreeMap<>(map);
        System.out.println("Construct TreeMap with map: " + treeMap3);

        // creating TreeMap from another Map
        Map<String, String> treeMap4 = new TreeMap<>(treeMap2);
        System.out.println("Construct TreeMap with another treemap: " + treeMap4);
    }

    private static void commonOperations() {
        // Add
        TreeMap<Integer, String> treeMap1 = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap1.put(i, i + "");
        }
        System.out.println("Common operations - add : " + treeMap1);

        // Check existence
        System.out.println("Check whether key 1 exists: " + treeMap1.containsKey(1));
        System.out.println("Check whether key 3 exists: " + treeMap1.containsKey(3));
        System.out.println("Check whether key 100 exists: " + treeMap1.containsKey(100));

        // Get value with key
        System.out.println("Value for Key 1 = " + treeMap1.get(1));
        System.out.println("Value for Key 100 = " + treeMap1.get(100));

        // Keys
        Set<Integer> keySet = treeMap1.keySet();
        System.out.println("Map keys = " + keySet);

        // Values
        Collection<String> values = treeMap1.values();
        System.out.println("Map values = " + values);

        // Entries
        Set<Map.Entry<Integer, String>> entrySet = treeMap1.entrySet();
        System.out.println("Map entries = " + entrySet);

        // lower and higher boundaries
        System.out.println("First entry is: " + treeMap1.firstEntry());
        System.out.println("Last entry is: " + treeMap1.lastEntry());
        System.out.println("Closest lower key than 4 is: "+ treeMap1.lowerKey(4));
        System.out.println("Closest higher key than 4 is: "+ treeMap1.higherKey(4));
        System.out.println("Closest lower entry than 5 is: " + treeMap1.lowerEntry(5));
        System.out.println("Closest higher entry than 5 is: " + treeMap1.higherEntry(5));
        System.out.println("Closest floor entry than 5 is: "+ treeMap1.floorEntry(5));
        System.out.println("Closest ceiling entry than 4 is: " + treeMap1.ceilingEntry(4));

        // poll first and last entries
        System.out.println("First entry(Polled) is: " + treeMap1.pollFirstEntry());
        System.out.println("Last entry(Polled) is: " + treeMap1.pollLastEntry());
        System.out.println("TreeMap after polling: " + treeMap1);

        // submap, headmap and tailmap
        Map<Integer, String> subMap = treeMap1.subMap(2, true, 6, true);
        System.out.println("Submap from 2 to 6 is: " + subMap);
        System.out.println("HeadMap to 5: " + treeMap1.headMap(5, true));
        System.out.println("TailMap from 5: " + treeMap1.tailMap(5, true));

        // reverse
        Map<Integer, String> descendingMap = treeMap1.descendingMap();
        System.out.println("Descending map: " + descendingMap);

        // remove
        treeMap1.remove(6);
        System.out.println("Remove element 6 : " + treeMap1);
    }

    private static void traverseTreeMap() {
        SortedMap<Integer, String> fruits = new TreeMap<>();
        fruits.put(4, "Banana");
        fruits.put(9, "Apple");
        fruits.put(5, "Orange");
        fruits.put(2, "Mango");

        // for each key
        for (Integer key : fruits.keySet()) {
            System.out.println("Traverse Key(for each): processing - " + key);
        }

        System.out.println();

        // for each value
        for (String value : fruits.values()) {
            System.out.println("Traverse Value(for each): processing - " + value);
        }

        System.out.println();

        // for each entry(key, value)
        for (Map.Entry<Integer, String> entry : fruits.entrySet()) {
            System.out.println("Traverse Entry(for each): processing - " + entry);
        }

        System.out.println();

        // entry iterator
        Iterator<Integer> iterator1 = fruits.keySet().iterator();

        while (iterator1.hasNext()) {
            Integer fruit = iterator1.next();
            System.out.println("Traverse Key(iterator): processing - " + fruit);
        }

        System.out.println();

        // entry iterator
        Iterator<String> iterator2 = fruits.values().iterator();

        while (iterator2.hasNext()) {
            String fruit = iterator2.next();
            System.out.println("Traverse Value(iterator): processing - " + fruit);
        }

        System.out.println();

        // entry iterator
        Iterator<Map.Entry<Integer, String>> iterator3 = fruits.entrySet().iterator();

        while (iterator3.hasNext()) {
            Map.Entry<Integer, String> fruit = iterator3.next();
            System.out.println("Traverse Entry(iterator): processing - " + fruit);
        }
    }

    private static void wrongWayToRemoveElement() {
        SortedMap<Integer, String> fruits = new TreeMap<>();
        fruits.put(4, "Banana");
        fruits.put(9, "Apple");
        fruits.put(5, "Orange");
        fruits.put(2, "Mango");

        // in for each loop
        for (Integer key : fruits.keySet()) {
            System.out.println("Traverse TreeMap(for each): processing - " + key);

            if (key == 5) {
                fruits.remove(5);  // java.util.ConcurrentModificationException is thrown
            }
        }

        // in iterator loop
        Iterator<Integer> iterator = fruits.keySet().iterator();

        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println("Traverse TreeMap(iterator): processing - " + key);

            if (key == 5) {
                fruits.remove(5);  // java.util.ConcurrentModificationException is thrown
            }
        }

        System.out.println("fruits tree map after remove = " + fruits);
    }

    private static void correctWayToRemoveElement() {
        SortedMap<Integer, String> fruits = new TreeMap<>();
        fruits.put(4, "Banana");
        fruits.put(9, "Apple");
        fruits.put(5, "Orange");
        fruits.put(2, "Mango");

        Iterator<Integer> iterator = fruits.keySet().iterator();

        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println("Remove element: processing - " + key + "=" + fruits.get(key));

            if (key == 5) {
                iterator.remove(); // iterator.remove not set.remove
            }
        }

        System.out.println("fruits tree map after remove = " + fruits);
    }

    private static void simpleUsage() {
        // Constructors
        SortedMap<Integer, String> treeMap1 = new TreeMap<>();
        SortedMap<Integer, String> treeMap2 = new TreeMap<>((a,b)->b-a);
        SortedMap<Integer, String> treeMap3 = new TreeMap<>(new HashMap<>());
        SortedMap<Integer, String> treeMap4 = new TreeMap<>(new TreeMap<>());

        // Add
        TreeMap<Integer, String> treeMap5 = new TreeMap<>();
        for (int i = 0; i < 6; i++) {
            treeMap5.put(i, i + "");
        }

        // Check exist
        treeMap5.containsKey(3);   // true
        treeMap5.containsKey(100); // false

        // lower and higher boundaries
        treeMap5.firstEntry();         // 0=0
        treeMap5.lastEntry();          // 9=9
        treeMap5.lowerKey(4);          // 3
        treeMap5.higherKey(4);         // 5
        treeMap5.lowerEntry(5);   // 4=4
        treeMap5.higherEntry(5);  // 6=6
        treeMap5.floorEntry(5);   // 5=5
        treeMap5.ceilingEntry(4); // 4=4

        // submap, headmap and tailmap
        Map<Integer, String> subMap = treeMap5.subMap(2, true, 6, true); // subMap = {2=2, 3=3, 4=4, 5=5, 6=6}
        Map<Integer, String> headMap = treeMap5.headMap(5, true);   // headMap = {1=1, 2=2, 3=3, 4=4, 5=5}
        Map<Integer, String> tailMap = treeMap5.tailMap(5, true); // tailMap = {5=5, 6=6, 7=7, 8=8}

        // Remove
        treeMap5.remove(2);                  // treeMap5 = {0=0, 1=1, 3=3, 4=4, 5=5}
        // Size
        int size = treeMap5.size();               // size = 5
    }

}
