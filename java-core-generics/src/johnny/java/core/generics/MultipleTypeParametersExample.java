package johnny.java.core.generics;

public class MultipleTypeParametersExample {
    public static void main(String[] args) {
        Box<Integer, String> box = new Box<Integer, String>();
        box.add(Integer.valueOf(10),"Hello World");
        System.out.format("Integer Value: %d\n", box.getFirst());
        System.out.format("String Value: %s\n", box.getSecond());

        Box<String, String> box1 = new Box<String, String>();
        box1.add("Message","Hello World");
        System.out.format("String Value: %s\n", box1.getFirst());
        System.out.format("String Value: %s\n", box1.getSecond());
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
