package johnny.java.core.iterator;

import java.util.ArrayList;
import java.util.List;

public class ModificationExceptionExample {
    public static void main(String args[]){
        List<String> books = new ArrayList<>();
        books.add("C");
        books.add("Java");
        books.add("Python");

        for (String book : books) {
            System.out.println(book);
            //We are adding element while iterating list
            books.add("C++");
        }
    }
}
