package johnny.java.core.generics.collections;

import java.util.*;

public class GenericMapExample {
    public static void main(String[] args) {

        Map<Integer,Integer> integerMap = new HashMap<Integer,Integer>();
        integerMap.put(1, 10);
        integerMap.put(2, 11);

        Map<String,String> stringMap = new HashMap<String,String>();
        stringMap.put("A", "Hello World");
        stringMap.put("B","Hi World");

        // access by key
        System.out.format("Integer Value: %d\n", integerMap.get(1));
        System.out.format("String Value: %s\n", stringMap.get("A"));

        // iterate keys.
        Iterator<Integer> integerIterator   = integerMap.keySet().iterator();
        while(integerIterator.hasNext()) {
            System.out.format("Integer Value: %d\n", integerIterator.next());
        }

        // iterate values.
        Iterator<String> stringIterator   = stringMap.values().iterator();
        while(stringIterator.hasNext()) {
            System.out.format("String Value: %s\n", stringIterator.next());
        }
    }
}