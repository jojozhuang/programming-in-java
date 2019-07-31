package johnny.java.core.generics.typeerasure;

public class BoundedTypesErasureExample {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<Double> doubleBox = new Box<Double>();

        integerBox.add(new Integer(10));
        doubleBox.add(new Double(10.0));

        System.out.format("Integer Value: %d\n", integerBox.get());
        System.out.format("Double Value: %s\n", doubleBox.get());
    }

    static class Box<T extends Number> {
        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }
}


