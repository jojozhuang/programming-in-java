package johnny.java.summary.collection;

import java.util.*;

public class SortedSetMapExample {
    public static void main(String[] args) {
        testTreeSet();
        testSortedMap();
    }

    public static void testTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10; i++) {
            treeSet.add(i);
        }
        //treeSet.add(null);         // java.lang.NullPointerException
        System.out.println(treeSet); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        treeSet.contains(2);         // true
        treeSet.contains(10);        // false
        treeSet.first();             // 0
        treeSet.last();              // 9
        treeSet.lower(4);         // 3
        treeSet.higher(4);        // 5
        treeSet.floor(5);         // 5
        treeSet.ceiling(4);       // 4
        treeSet.pollFirst();         // 0
        treeSet.pollLast();          // 9
        System.out.println(treeSet); // [1, 2, 3, 4, 5, 6, 7, 8]

        // submap, headmap and tailmap
        Set<Integer> subSet1 = treeSet.subSet(2, true, 6, true); // [2, 3, 4, 5, 6]
        Set<Integer> subSet2 = treeSet.headSet(5, true);   // [1, 2, 3, 4, 5]
        Set<Integer> subSet3 = treeSet.tailSet(5, true); // [5, 6, 7, 8]

        // reverse
        Set<Integer> descendingSet = treeSet.descendingSet(); //[8, 7, 6, 5, 4, 3, 2, 1]
        // remove
        treeSet.remove(6); // [1, 2, 3, 4, 5, 7, 8]
    }

    public static void testSortedMap() {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            treeMap.put(i, String.valueOf((char)('A' + i)));
        }
        //treeMap.put(null, null);       // key can't be null, java.lang.NullPointerException
        //treeMap.put(20, null);         // it's ok to have null for value
        System.out.println(treeMap);     // {0=A, 1=B, 2=C, 3=D, 4=E, 5=F, 6=G, 7=H, 8=I, 9=J}

        // Check existence
        treeMap.containsKey(1);   // true
        treeMap.containsKey(3);   // true
        treeMap.containsKey(100); // false

        // Get value with key
        treeMap.get(0);   // A
        treeMap.get(9);   // J
        treeMap.get(100); // null

        // Keys
        Set<Integer> keySet = treeMap.keySet();       // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Values
        Collection<String> values = treeMap.values(); // [A, B, C, D, E, F, G, H, I, J]

        // Entries
        Set<Map.Entry<Integer, String>> entrySet = treeMap.entrySet(); // [0=A, 1=B, 2=C, 3=D, 4=E, 5=F, 6=G, 7=H, 8=I, 9=J]

        // lower and higher boundaries
        treeMap.firstEntry();         // 0=A
        treeMap.lastEntry();          // 9=J
        treeMap.lowerKey(4);          // 3
        treeMap.higherKey(4);         // 5
        treeMap.lowerEntry(5);   // 4=E
        treeMap.higherEntry(5);  // 6=G
        treeMap.floorEntry(5);   // 5=F
        treeMap.ceilingEntry(4); // 4=E

        // poll first and last entries
        treeMap.pollFirstEntry();     // 0=A
        treeMap.pollLastEntry();      // 9=J
        System.out.println(treeMap);  // {1=B, 2=C, 3=D, 4=E, 5=F, 6=G, 7=H, 8=I}

        // submap, headmap and tailmap
        Map<Integer, String> subMap1 = treeMap.subMap(2, true, 6, true); // {2=C, 3=D, 4=E, 5=F, 6=G}
        Map<Integer, String> subMap2 = treeMap.headMap(5, true);   //  {1=B, 2=C, 3=D, 4=E, 5=F}
        Map<Integer, String> subMap3 = treeMap.tailMap(5, true); //  {5=F, 6=G, 7=H, 8=I}

        // reverse
        Map<Integer, String> descendingMap = treeMap.descendingMap(); //{8=I, 7=H, 6=G, 5=F, 4=E, 3=D, 2=C, 1=B}

        // remove
        treeMap.remove(6); // {1=B, 2=C, 3=D, 4=E, 5=F, 7=H, 8=I}

    }
}
