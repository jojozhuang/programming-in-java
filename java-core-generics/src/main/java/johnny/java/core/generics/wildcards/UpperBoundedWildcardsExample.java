package johnny.java.core.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildcardsExample {
    public static void print(List<? extends Fruit> list, String type) {
        System.out.println(type + " list is printed");
    }

    public static void main(String[] args) {
        List<Food> foods = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        List<Banana> bananas = new ArrayList<>();

        //compile time error: can't call print method
        //print(foods, "food" );

        //add fruit list
        print(fruits, "fruit");

        //add apple list
        print(apples, "apple");

        //add banana list
        print(bananas, "banana");
    }

    static class Food {}

    static class Fruit extends Food {}

    static class Apple extends Fruit {}

    static class Banana extends Fruit {}
}
