package johnny.java.core.staticblock;

public class InitializationBlockExample {
    {
        System.out.println("This is Initialization Block 1!");
    }
    {
        System.out.println("This is Initialization Block 2!");
    }
    public InitializationBlockExample() {
        System.out.println("Hi, I'm Constructor 1!");
    }
    public InitializationBlockExample(String name) {
        System.out.println("Hi, " + name + "! I'm Constructor 2!");
    }

    public static void main(String[] args) {
        InitializationBlockExample object1 = new InitializationBlockExample();
        InitializationBlockExample object3 = new InitializationBlockExample("Johnny");
    }
}
