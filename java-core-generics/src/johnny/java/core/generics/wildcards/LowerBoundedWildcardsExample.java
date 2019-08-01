package johnny.java.core.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcardsExample {
    public static void print(List<? super Fruit> list, String type) {
        System.out.println(type + " list is printed");
    }

    public static void main(String[] args) {
        List<Food> foods = new ArrayList<>();
        List<Fruit> fruits = new ArrayList<>();
        List<Apple> apples = new ArrayList<>();
        List<Banana> bananas = new ArrayList<>();

        //add food list
        print(foods, "food" );

        //add fruit list
        print(fruits, "fruit");

        //compile time error: can't call print method
        //print(apples, "apple");

        //compile time error: can't call print method
        //print(bananas, "banana");
    }

    static class Food {}

    static class Fruit extends Food {}

    static class Apple extends Fruit {}

    static class Banana extends Fruit {}
}
