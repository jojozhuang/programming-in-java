package johnny.java.core.staticblock;

// Child Class
public class Child extends Parent {
    {
        System.out.println("This is child block!");
    }

    public Child() {
        super();
        System.out.println("Child Constructor is Called.");
    }
}
