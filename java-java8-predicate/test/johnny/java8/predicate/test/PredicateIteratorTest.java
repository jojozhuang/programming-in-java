package johnny.java8.predicate.test;

import johnny.java8.predicate.BiggerThanFivePredicate;
import johnny.java8.predicate.PredicateIterator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PredicateIteratorTest {
    @Test
    public void testPredicateIterator() {
        System.out.println("testPredicateIterator");

        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{3,5,6,8,2,4,7,1}));
        BiggerThanFivePredicate btf = new BiggerThanFivePredicate();
        PredicateIterator instance = new PredicateIterator(list.iterator(), btf);
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(6, (int)instance.next());
        assertEquals(8, (int)instance.next());
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(7, (int)instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }

    @Test
    public void testPredicateIterator2() {
        System.out.println("testPredicateIterator2");

        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{}));
        BiggerThanFivePredicate btf = new BiggerThanFivePredicate();
        PredicateIterator instance = new PredicateIterator(list.iterator(), btf);
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }

    @Test
    public void testPredicateIterator3() {
        System.out.println("testPredicateIterator3");

        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{6}));
        BiggerThanFivePredicate btf = new BiggerThanFivePredicate();
        PredicateIterator instance = new PredicateIterator(list.iterator(), btf);
        assertEquals(true, instance.hasNext());
        assertEquals(true, instance.hasNext());
        assertEquals(6, (int)instance.next());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }

    @Test
    public void testPredicateIterator4() {
        System.out.println("testPredicateIterator4");

        List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{6}));
        BiggerThanFivePredicate btf = new BiggerThanFivePredicate();
        PredicateIterator instance = new PredicateIterator(list.iterator(), btf);
        assertEquals(6, (int)instance.next());
        assertEquals(null, instance.next());
        assertEquals(false, instance.hasNext());
        assertEquals(false, instance.hasNext());
    }
}
