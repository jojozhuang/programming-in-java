package johnny.java.core.staticblock;

public class StaticBlockExample {
    static {
        //static block
        System.out.println("Hi, I'm a Static Block!");
    }

    public StaticBlockExample() {
        System.out.println("Hi, I'm Constructor 1!");
    }

    public StaticBlockExample(String name) {
        System.out.println("Hi, " + name + "! I'm Constructor 2!");
    }

    public static void main(String[] args) {
        StaticBlockExample object1 = new StaticBlockExample();
        StaticBlockExample object2 = new StaticBlockExample("Johnny");
    }
}
