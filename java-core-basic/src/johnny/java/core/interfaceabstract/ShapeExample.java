package johnny.java.core.interfaceabstract;

public class ShapeExample {
    public static void main(String[] args) {

        testInterface();
        testAbstractClass();
    }

    private static void testInterface() {
        System.out.println("Test interface...");
        // programming for interfaces not implementation
        Shape shape = new Circle(5);
        shape.draw();
        System.out.println("Area = " + shape.area());

        // switching from one implementation to another easily
        shape = new Rectangle(2,8);
        shape.draw();
        System.out.println("Area = " + shape.area());
    }

    private static void testAbstractClass() {
        System.out.println("Test abstract class...");
        // programming for interfaces not implementation
        BaseShape shape = new CircleImp(5);
        shape.draw();
        System.out.println("Area = " + shape.area());

        // switching from one implementation to another easily
        shape = new RectangleImp(2,8);
        shape.draw();
        System.out.println("Area = " + shape.area());
    }
}
