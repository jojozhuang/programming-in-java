package johnny.java.core.iterator.test;

import johnny.java.core.iterator.custom.CommonIterator;
import johnny.java.core.iterator.custom.SortedIterator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommonIteratorTest {
    @Test
    public void testSortedIterator() {
        System.out.println("testSortedIterator");
        SortedIterator itr1 = new SortedIterator(new int[]{1,3,5,7,9});
        SortedIterator itr2 = new SortedIterator(new int[]{2,3,4,8,9});
        CommonIterator instance = new CommonIterator(itr1, itr2);

        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(3, (int)instance.next());
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(9, (int)instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }

    @Test
    public void testSortedIterator2() {
        System.out.println("testSortedIterator2");
        SortedIterator itr1 = new SortedIterator(new int[]{});
        SortedIterator itr2 = new SortedIterator(new int[]{2,3,4,8,9});
        CommonIterator instance = new CommonIterator(itr1, itr2);

        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }

    @Test
    public void testSortedIterator3() {
        System.out.println("testSortedIterator3");
        SortedIterator itr1 = new SortedIterator(new int[]{});
        SortedIterator itr2 = new SortedIterator(new int[]{});
        CommonIterator instance = new CommonIterator(itr1, itr2);

        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }

    @Test
    public void testSortedIterator4() {
        System.out.println("testSortedIterator4");
        SortedIterator itr1 = new SortedIterator(new int[]{1});
        SortedIterator itr2 = new SortedIterator(new int[]{1});
        CommonIterator instance = new CommonIterator(itr1, itr2);

        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(1, (int)instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
    }
}
