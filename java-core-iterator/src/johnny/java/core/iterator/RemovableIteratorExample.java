package johnny.java.core.iterator;

import johnny.java.core.iterator.custom.RemovableIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemovableIteratorExample {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3,5,6,8,2,4,7,1}));
        RemovableIterator iterator = new RemovableIterator(list);
        while (iterator.hasNext()){
            Integer number = iterator.next();
            System.out.println("Processing - " + number);

            if(number == 8 || number == 2) {
                iterator.remove();
            }
        }

        System.out.println("list after iteration = " + list);
    }
}
