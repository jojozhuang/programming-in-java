package johnny.java.core.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String args[]){
        List<String> names = new ArrayList();
        names.add("Peter");
        names.add("Paul");
        names.add("Johnny");

        Iterator<String> it = names.iterator();

        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }
    }
}
