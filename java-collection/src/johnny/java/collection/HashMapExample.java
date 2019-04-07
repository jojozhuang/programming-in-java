package johnny.java.collection;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {

        constructHashMap();
        commonOperations();
        traverseHashMap();
        //wrongWayToRemoveElement();
        correctWayToRemoveElement();
        simpleUsage();
    }

    private static void constructHashMap() {
        Map<String, String> map1 = new HashMap<>();
        map1.put("A", "A"); // put example
        map1.put("B", "B");
        map1.put("C", "C");
        map1.put("D", null); // null value
        map1.put(null, "Z"); // null key
        System.out.println("Construct HashMap: " + map1);

        // initial capacity should be power of 2
        Map<String, String> map2 = new HashMap<>(32);

        // setting backing HashMap initial capacity and load factor
        Map<String, String> map3 = new HashMap<>(32, 0.80f);

        // creating HashMap from another Map
        Map<String, String> map4 = new HashMap<>(map1);
        System.out.println("Construct HashMap with another map: " + map4);
    }

    private static void commonOperations() {
        // Add key value pair to map
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("A", "A"); // put example
        hashMap.put("B", "B");
        hashMap.put("C", "C");
        hashMap.put("D", null); // null value
        hashMap.put(null, "Z"); // null key

        // Check key existence
        System.out.println("Check whether key 'A' exists: " + hashMap.containsKey("A"));
        System.out.println("Check whether key 'D' exists: " + hashMap.containsKey("D"));
        System.out.println("Check whether key 'M' exists: " + hashMap.containsKey("M"));
        System.out.println("Check whether key 'null' exist : " + hashMap.containsKey(null));

        // Get value with key
        System.out.println("Value for Key C = " + hashMap.get("C"));
        System.out.println("Value for Key null = " + hashMap.get(null));

        // Keys
        Set<String> keySet = hashMap.keySet();
        System.out.println("Map keys = " + keySet);

        // Values
        Collection<String> values = hashMap.values();
        System.out.println("Map values = " + values);

        // Entries
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        System.out.println("Map entries = " + entrySet);

        // Remove
        hashMap.remove("B");
        System.out.println("Remove entry whose key is B : " + hashMap);
    }

    private static void traverseHashMap() {
        Map<Integer, String> fruits = new HashMap<>();
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
        Map<Integer, String> fruits = new HashMap<>();
        fruits.put(4, "Banana");
        fruits.put(9, "Apple");
        fruits.put(5, "Orange");
        fruits.put(2, "Mango");

        // in for each loop
        for (Integer key : fruits.keySet()) {
            System.out.println("Traverse HashMap(for each): processing - " + key);

            if (key == 5) {
                fruits.remove(5);  // java.util.ConcurrentModificationException is thrown
            }
        }

        // in iterator loop
        Iterator<Integer> iterator = fruits.keySet().iterator();

        while (iterator.hasNext()){
            Integer key = iterator.next();
            System.out.println("Traverse HashMap(iterator): processing - " + key);

            if (key == 5) {
                fruits.remove(5);  // java.util.ConcurrentModificationException is thrown
            }
        }

        System.out.println("fruits map after remove = " + fruits);
    }

    private static void correctWayToRemoveElement() {
        Map<Integer, String> fruits = new HashMap<>();
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

        System.out.println("fruits map after remove = " + fruits);
    }

    private static void simpleUsage() {
        // Constructors
        Map<Integer, String> hashMap1 = new HashMap<>();
        Map<Integer, String> hashMap2 = new HashMap<>(32);
        Map<Integer, String> hashMap3 = new HashMap<>(32, 0.80f);
        Map<Integer, String> hashMap4 = new HashMap<>(new HashMap<>());

        // Add
        Map<Integer, String> hashMap5 = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            hashMap5.put(i, i + "");
        }

        // Check exist
        boolean exists = hashMap5.containsKey(3); // true
        // Remove
        hashMap5.remove(2);                  // hashMap5 = {0=0, 1=1, 3=3, 4=4, 5=5}
        // Size
        int size = hashMap5.size();               // size = 5
    }
}
