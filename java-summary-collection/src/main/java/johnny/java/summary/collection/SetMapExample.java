package johnny.java.summary.collection;

import java.util.*;

public class SetMapExample {
    public static void main(String[] args) {
        testSet();
        testMap();
    }

    public static void testSet() {
        Set<Integer> set = new HashSet<>();
        set.add(null);      // null element
        set.add(1);
        set.add(2);         // [null, 1, 2]

        set.contains(1);    // true
        set.contains(3);    // false
        set.contains(null); // true

        set.remove(1);   // [null, 2]

        // for each
        for (Integer item : set) {
            System.out.println(item); // 2
        }
    }

    public static void testMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", null);      // null value
        map.put(null, 0);        // null key

        System.out.println(map); // {null=0, A=1, B=2, C=3, D=null}

        map.containsKey("A");    // true
        map.containsKey("D");    // true
        map.containsKey("E");    // false
        map.containsKey(null);   // true

        map.get("A");            // 1
        map.get("D");            // null
        map.get(null);           // 0
        map.get("E");            // null

        // Keys
        Set<String> keys = map.keySet(); // [null, A, B, C, D]

        // Values
        Collection<Integer> values = map.values(); // [0, 1, 2, 3, null]

        // Entries
        Set<Map.Entry<String, Integer>> entries = map.entrySet(); //[null=0, A=1, B=2, C=3, D=null]

        map.remove("A");   //  {null=0, B=2, C=3, D=null}
    }
}
