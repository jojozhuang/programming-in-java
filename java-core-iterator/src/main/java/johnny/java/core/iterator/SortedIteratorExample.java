package johnny.java.core.iterator;

import johnny.java.core.iterator.custom.SortedIterator;

public class SortedIteratorExample {
    public static void main(String args[]){
        SortedIterator iterator = new SortedIterator(new int[]{3,6,8,2,4,7,1});

        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }
    }
}
