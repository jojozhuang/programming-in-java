package johnny.java.core.iterator;

import johnny.java.core.iterator.custom.BiggerThanFivePredicate;
import johnny.java.core.iterator.custom.PredicateIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PredicateIteratorExample {
    public static void main(String args[]){
        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3,5,6,8,2,4,7,1}));
        BiggerThanFivePredicate btf = new BiggerThanFivePredicate();
        PredicateIterator iterator = new PredicateIterator(list.iterator(), btf);

        while (iterator.hasNext()) {
            Integer num = iterator.next();
            System.out.println(num);
        }
    }
}
