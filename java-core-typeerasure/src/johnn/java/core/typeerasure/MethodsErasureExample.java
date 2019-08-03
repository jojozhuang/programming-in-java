package johnn.java.core.typeerasure;

public class MethodsErasureExample {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        Box<String> stringBox = new Box<String>();

        integerBox.add(new Integer(10));
        stringBox.add(new String("Hello World"));

        printBox1(integerBox);
        printBox2(stringBox);
    }

    private static <T extends Box> void printBox1(T box) {
        System.out.println("Integer Value: " + box.get());
    }

    private static <T> void printBox2(T box) {
        System.out.println("String Value: " + ((Box)box).get());
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
