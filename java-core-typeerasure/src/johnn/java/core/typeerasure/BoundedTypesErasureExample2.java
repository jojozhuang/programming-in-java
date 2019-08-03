package johnn.java.core.typeerasure;

public class BoundedTypesErasureExample2 {
    public static void main(String[] args) {
        Box integerBox = new Box();
        Box doubleBox = new Box();

        integerBox.add(new Integer(10));
        doubleBox.add(new Double(10.0));

        System.out.format("Integer Value: %d\n", integerBox.get());
        System.out.format("Double Value: %s\n", doubleBox.get());
    }

    static class Box {
        private Number t;

        public void add(Number t) {
            this.t = t;
        }

        public Number get() {
            return t;
        }
    }
}