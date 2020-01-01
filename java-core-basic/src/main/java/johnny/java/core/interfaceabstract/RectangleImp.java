package johnny.java.core.interfaceabstract;

public class RectangleImp extends BaseShape {
    private double width;
    private double height;

    public RectangleImp(double width, double height){
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing rectangle...");
    }

    @Override
    public double area() {
        return this.height * this.width;
    }
}
