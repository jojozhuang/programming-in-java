package johnny.java.core.iterator.test;

import johnny.java.core.iterator.custom.SortedIterator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SortedIteratorTest {
    @Test
    public void testSortedIterator() {
        System.out.println("testSortedIterator");
        SortedIterator instance = new SortedIterator(new int[]{3,6,8,2,4,7,1});
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(1, (int)instance.next());
        assertEquals(2, (int)instance.next());
        assertEquals(3, (int)instance.next());
        assertEquals(4, (int)instance.next());
        assertEquals(true, instance.hasNext());
        assertEquals(6, (int)instance.next());
        assertEquals(7, (int)instance.next());
        assertEquals(8, (int)instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }
}
