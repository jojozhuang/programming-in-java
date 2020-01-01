package johnny.java8.predicate;

import java.util.Iterator;

public class PredicateIterator implements Iterator<Integer> {

    private Iterator<Integer> itr;
    private BiggerThanFivePredicate btf;
    private Integer next;
    public PredicateIterator(Iterator<Integer> itr, BiggerThanFivePredicate btf) {
        this.itr = itr;
        this.btf = btf;
    }

    @Override
    public boolean hasNext(){
        if (next != null) {
            return true;
        }

        while (itr.hasNext()) {
            Integer num = itr.next();
            if (btf.test(num)) {
                next = num;
                return true;
            }
        }

        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int temp = next;
            next = null;
            return temp;
        }

        return null;
    }
}