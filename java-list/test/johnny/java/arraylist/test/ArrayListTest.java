package johnny.java.arraylist.test;

import static org.junit.Assert.*;

import org.junit.Test;

import johnny.java.list.ArrayList;

public class ArrayListTest {
    
    @Test
    public void test() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        assertEquals(0, list.size());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        list.add(3);
        list.add(4);
        assertEquals(5, list.size());
        assertTrue(1 == list.get(0));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));
        assertTrue(3 == list.get(3));
        assertTrue(4 == list.get(4));

        assertTrue(5 == list.size());
        
        list.remove(3);
        assertEquals(4, list.size());
        assertTrue(1 == list.get(0));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));
        assertTrue(4 == list.get(3));
        
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testLowerBound() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.get(-1); // OutOfBounds
    }
    
    @Test(expected=IndexOutOfBoundsException.class)
    public void testHigherBound() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.get(6); // OutOfBounds
    }
}
