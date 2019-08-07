package johnny.java.core.scanner;

public class OrderItem {
    public String name;
    public double price;
    public int quantity;

    public OrderItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}