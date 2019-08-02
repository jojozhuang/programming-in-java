package johnny.java.core.iterator.test;

import johnny.java.core.iterator.custom.RemovableIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RemovableIteratorTest {
    @Test
    public void testRemoveIterator() {
        System.out.println("testRemoveIterator");

        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3,5,6,8,2,4,7,1}));
        RemovableIterator iterator = new RemovableIterator(list);
        assertEquals(true, iterator.hasNext());
        assertEquals(true, iterator.hasNext());
        assertEquals(true, iterator.hasNext());
        assertEquals(3, (int)iterator.next());
        assertEquals(5, (int)iterator.next());
        assertEquals(6, (int)iterator.next());
        assertEquals(8, (int)iterator.next());
        iterator.remove(); // remove 8
        assertEquals(2, (int)iterator.next());
        iterator.remove(); // remove 2
        assertEquals(true, iterator.hasNext());
        assertEquals(4, (int)iterator.next());
        assertEquals(7, (int)iterator.next());
        assertEquals(1, (int)iterator.next());
        assertEquals(false, iterator.hasNext());
        assertEquals(null, iterator.next());
        assertEquals(false, iterator.hasNext());
        assertEquals(false, iterator.hasNext());
    }
}
