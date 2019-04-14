package johnny.java.defaultmethod;

public class DefaultMethodExample {
    public static void main(String args[]) {
        Vehicle vehicle = new Car();
        vehicle.print();
    }
}

interface Vehicle {
    // default method
    default void print() {
        System.out.println("I am a vehicle!");
    }

    // static method
    static void blowHorn() {
        System.out.println("Blowing horn!!!");
    }
}

interface FourWheeler {
    default void print() {
        System.out.println("I am a four wheeler!");
    }
}

class Car implements Vehicle, FourWheeler {
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
        System.out.println("I am a car!");
    }
}
