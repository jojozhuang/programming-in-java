package johnny.java.core.generics.typeerasure;

public class UnboundedTypesErasureExample2 {
    public static void main(String[] args) {
        Box integerBox = new Box();
        Box stringBox = new Box();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));

        System.out.format("Integer Value: %d\n", integerBox.get());
        System.out.format("String Value: %s\n", stringBox.get());
    }

    static class Box {
        private Object t;

        public void add(Object t) {
            this.t = t;
        }

        public Object get() {
            return t;
        }
    }
}

