package johnny.java.jvm;

public class StaticBlockTest {
    static {
        //static block
        System.out.println("Hi, I'm a Static Block!");
    }
    public StaticBlockTest() {
        System.out.println("Constructor 1 Says Hi!");
    }
    public StaticBlockTest(String name) {
        System.out.println("Constructor 2 Says Hi!" + name);
    }

    public static void main(String[] args) {
        StaticBlockTest object1 = new StaticBlockTest();
        StaticBlockTest object2 = new StaticBlockTest();
        StaticBlockTest object3 = new StaticBlockTest("Johnny");
    }
}
