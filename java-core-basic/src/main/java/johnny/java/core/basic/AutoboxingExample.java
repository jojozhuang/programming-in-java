package johnny.java.core.basic;

import java.util.ArrayList;
import java.util.List;

public class AutoboxingExample {
    public static void main(String[] args) {
        int i = 6;
        long j = 105L;

        // passed the int, will get converted to Integer object at Runtime using
        // autoboxing in java
        doSomething(i);

        List<Long> list = new ArrayList<>();

        // java autoboxing to add primitive type in collection classes
        list.add(j);
    }

    private static void doSomething(Integer in) {
        // unboxing in java, at runtime Integer.intValue() is called implicitly to return int
        int j = in;

        // java unboxing, Integer is passed where int is expected
        doPrimitive(in);
    }

    private static void doPrimitive(int i) {

    }
}
