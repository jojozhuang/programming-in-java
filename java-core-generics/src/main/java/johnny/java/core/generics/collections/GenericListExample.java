package johnny.java.core.generics.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GenericListExample {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<Integer>();
        integerList.add(Integer.valueOf(10));
        integerList.add(Integer.valueOf(11));

        List<String> stringList = new ArrayList<String>();
        stringList.add("Hello World");
        stringList.add("Hi World");

        // access by index
        System.out.format("Integer Value: %d\n", integerList.get(0));
        System.out.format("String Value: %s\n", stringList.get(0));

        // for loop
        for(Integer data: integerList) {
            System.out.format("Integer Value: %d\n", data);
        }

        // iterator
        Iterator<String> stringIterator = stringList.iterator();
        while(stringIterator.hasNext()) {
            System.out.format("String Value: %s\n", stringIterator.next());
        }
    }
}