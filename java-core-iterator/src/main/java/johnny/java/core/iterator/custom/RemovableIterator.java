package johnny.java.core.iterator.custom;

import java.util.Iterator;
import java.util.List;

public class RemovableIterator implements Iterator<Integer> {

    private List<Integer> list;
    private int last = -1;
    private int curr = 0;
    public RemovableIterator(List<Integer> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext(){
        if (curr < list.size()) {
            return true;
        }

        return false;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            last = curr;
            curr++;
            return list.get(last);
        }

        return null;
    }

    @Override
    public void remove() {
        if (last > 0) {
            //throw exception
        }

        list.remove(last);
        curr = last; // keep the current position
        last = -1;
    }
}

