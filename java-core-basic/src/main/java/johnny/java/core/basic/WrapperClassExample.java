package johnny.java.core.basic;

import java.util.ArrayList;
import java.util.List;

public class WrapperClassExample {
    public static void main(String args[]){
        int i = 10;
        char c = 'a';

        // primitives are simple to use
        int j = i + 3;

        // polymorphism achieved by Wrapper classes, we can't pass primitive here
        doSomething(new Character(c));

        List<Integer> list = new ArrayList<>();
        // wrapper classes can be used in Collections
        Integer in = new Integer(i);
        list.add(in);

        // autoboxing takes care of primitive to wrapper class conversion
        list.add(j);

        // wrapper classes can be null
        in = null;

        Integer ix = new Integer(12);
        System.out.println(ix); // ix = 12
        modify(ix);
        System.out.println(ix); // ix is still 12
    }

    private static void doSomething(Object obj){

    }

    private static void modify(Integer ix) {
        ix = ix + 1;
        System.out.println(ix); // ix = 13
    }
}
