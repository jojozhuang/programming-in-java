package johnny.java.core.iterator.custom;

/*
    Give two sorted iterator, implement a common element iterator.
    For example:
    Suppose we have iterator1, which contains int array [1,3,5,7,9].
    And we also have iterator2, which contains int array [2,3,4,8,9].
    The common element iterator should return the common elements(3 and 9) in the above two iterator.
 */

import java.util.Iterator;

public class CommonIterator implements Iterator {

    private SortedIterator itr1;
    private SortedIterator itr2;
    private Integer common;

    public CommonIterator(SortedIterator itr1, SortedIterator itr2) {
        this.itr1 = itr1;
        this.itr2 = itr2;
    }

    @Override
    public boolean hasNext(){
        if (common != null) {
            return true;
        }

        if (!itr1.hasNext() || !itr2.hasNext()) {
            return false;
        }

        Integer num1 = itr1.next();
        Integer num2 = itr2.next();

        if (num1 == num2) {
            common = num1;
            return true;
        }

        while (num1 != num2) {
            if (num1 < num2) {
                if (!itr1.hasNext()) {
                    return false;
                }
                num1 = itr1.next();
            } else {
                if (!itr2.hasNext()) {
                    return false;
                }
                num2 = itr2.next();
            }
        }

        common = num1;
        return true;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            int temp = common;
            common = null;
            return temp;
        } else {
            return null;
        }
    }
}