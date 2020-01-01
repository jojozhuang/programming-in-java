package johnny.java.core.staticblock;

public class InitializationBlockExample2 {
    {
        System.out.println("This is Initialization Block 1!");
    }
    {
        System.out.println("This is Initialization Block 2!");
    }
    public InitializationBlockExample2() {
        System.out.println("Hi, I'm Constructor 1!");
    }
    public InitializationBlockExample2(String name) {
        System.out.println("Hi, " + name + "! I'm Constructor 2!");
    }

    public static void main(String[] args) {
        InitializationBlockExample2 object1 = new InitializationBlockExample2();
        InitializationBlockExample2 object3 = new InitializationBlockExample2("Johnny");
    }
}
