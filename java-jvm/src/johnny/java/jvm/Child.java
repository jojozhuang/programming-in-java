package johnny.java.jvm;

// Child Class
public class Child extends Parent {
    {
        System.out.println("This is child block");
    }
    Child() {
        super();
        System.out.println("Child Constructor is Called");
    }
}
