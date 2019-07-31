package johnny.java.core.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildcards {

    public static void addCat(List<? super Cat> catList) {
        catList.add(new RedCat());
        System.out.println("Cat list added.");
    }

    public static void main(String[] args) {
        List<Animal> animalList= new ArrayList<Animal>();
        List<Cat> catList= new ArrayList<Cat>();
        List<RedCat> redCatList= new ArrayList<RedCat>();
        List<Dog> dogList= new ArrayList<Dog>();

        //add list of super class Animal of Cat class
        addCat(animalList);

        //add list of Cat class
        addCat(catList);

        //compile time error: can't add list of RedCat into list of Cat
        //addCat(redCatList);

        //compile time error: can't add list of Dog into list of Cat
        //addCat(dogList);
    }

    static class Animal {}

    static class Cat extends Animal {}

    static class RedCat extends Cat {}

    static class Dog extends Animal {}
}
