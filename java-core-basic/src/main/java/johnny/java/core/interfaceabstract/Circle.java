package johnny.java.core.interfaceabstract;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle...");
    }

    @Override
    public double area() {
        return this.radius * this.radius * Math.PI;
    }
}
