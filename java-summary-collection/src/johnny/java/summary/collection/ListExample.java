package johnny.java.summary.collection;

import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        // construct array list
        List<Integer> list = new ArrayList<>();
        // List<Integer> list = new LinkedList<>();
        // add
        list.add(1);
        list.add(2);
        // insert
        list.add(0, 8);
        // get by index
        list.get(0);
        // remove
        list.remove(0);
    }
}
