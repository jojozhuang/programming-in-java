package johnny.java.core.iterator.custom;

import java.util.Arrays;
import java.util.Iterator;

public class SortedIterator implements Iterator<Integer> {

    private Integer[] nums;
    private int index;
    public SortedIterator(int[] arr) {
        if (arr != null && arr.length > 0) {
            this.nums = new Integer[arr.length];
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                nums[i] = arr[i];
            }
            index = 0;
        } else {
            nums = new Integer[]{};
            index = 0;
        }
    }

    @Override
    public boolean hasNext(){
        return index >= 0 && index < nums.length;
    }

    @Override
    public Integer next() {
        if (index < 0 || index >= nums.length) {
            return null;
        }

        return nums[index++];
    }
}
