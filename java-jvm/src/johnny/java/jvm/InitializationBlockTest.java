package johnny.java.jvm;

public class InitializationBlockTest {
    {
        System.out.println("This is Initialization Block 1!");
    }
    {
        System.out.println("This is Initialization Block 2!");
    }
    public InitializationBlockTest() {
        System.out.println("Constructor 1 Says Hi!");
    }
    public InitializationBlockTest(String name) {
        System.out.println("Constructor 2 Says Hi!" + name);
    }

    public static void main(String[] args) {
        InitializationBlockTest object1 = new InitializationBlockTest();
        InitializationBlockTest object2 = new InitializationBlockTest();
        InitializationBlockTest object3 = new InitializationBlockTest("Johnny");
    }
}
