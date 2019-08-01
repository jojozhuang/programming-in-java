package johnny.java.core.generics;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTypesExample {
    public static void main(String[] args) {
        Box<Integer, List<String>> box
                = new Box<Integer, List<String>>();

        List<String> messages = new ArrayList<String>();

        messages.add("Hi");
        messages.add("Hello");
        messages.add("Bye");

        box.add(Integer.valueOf(10),messages);
        System.out.format("Integer Value: %d\n", box.getFirst());
        System.out.format("String Value: %s\n", box.getSecond());
    }

    static class Box<T, S> {
        private T t;
        private S s;

        public void add(T t, S s) {
            this.t = t;
            this.s = s;
        }

        public T getFirst() {
            return t;
        }

        public S getSecond() {
            return s;
        }
    }
}
