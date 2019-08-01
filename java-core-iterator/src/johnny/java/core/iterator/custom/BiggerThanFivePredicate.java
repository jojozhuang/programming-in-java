package johnny.java.core.iterator.custom;

import java.util.function.Predicate;

public class BiggerThanFivePredicate implements Predicate<Integer> {
    @Override
    public boolean test(Integer val) {

        Integer five = 5;

        return val > five;
    }
}
