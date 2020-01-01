package johnn.java.core.typeerasure;

public class MethodsErasureExample2 {
    public static void main(String[] args) {
        Box integerBox = new Box();
        Box stringBox = new Box();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));

        printBox1(integerBox);
        printBox2(stringBox);
    }

    //Bounded Types Erasure
    private static void printBox1(Box box) {
        System.out.println("Integer Value: " + box.get());
    }

    //Unbounded Types Erasure
    private static void printBox2(Object box) {
        System.out.println("String Value: " + ((Box)box).get());
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

