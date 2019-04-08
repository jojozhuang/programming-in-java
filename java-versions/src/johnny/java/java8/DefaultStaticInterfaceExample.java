package johnny.java.java8;

public class DefaultStaticInterfaceExample {
    public static void main(String[] args) {
        MyClass myobj = new MyClass();
        myobj.method1("m1");
        myobj.method2();
        myobj.method3();
        myobj.method4();
        myobj.log("call from main");
    }
}

class MyClass implements Interface1, Interface2 {
    @Override
    public void method1(String str) {
    }

    @Override
    public void method2() {
    }

    //MyClass won't compile without having it's own log() implementation
    @Override
    public void log(String str){
        System.out.println("MyClass logging::"+str);
        Interface1.print("abc");
    }

}

interface Interface1 {

    void method1(String str);

    default void method3() {
        System.out.println("I1 method3");
    }

    default void log(String str){
        System.out.println("I1 logging::"+str);
    }

    static void print(String str){
        System.out.println("Printing "+str);
    }

    //trying to override Object method gives compile time error as
    //"A default method cannot override a method from java.lang.Object"
    /*default String toString(){
        return "i1";
    }*/
}

interface Interface2 {

    void method2();

    default void method4() {
        System.out.println("I2 method4");
    }

    default void log(String str){
        System.out.println("I2 logging::"+str);
    }

}