package johnny.java.core.generics;

public class TypeInferenceExample {
    public static void main(String[] args) {
        //type inference
        Box<Integer> integerBox = new Box<>();
        //unchecked conversion warning
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));

        System.out.format("Integer Value: %d\n", integerBox.get());
        System.out.format("String Value: %s\n", stringBox.get());
    }

    static class Box<T> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }
}

