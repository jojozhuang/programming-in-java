package johnny.java.shallow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShallowCopyExample {
    public static void main(String[] args) {
        shallowCopy();
        System.out.println();
        deepCopy();
    }

    private static void shallowCopy() {
        System.out.println("Shallow copy example:");

        Person p1 = new Person("Johnny");
        Person p2 = new Person("Sean");

        List<Person> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);

        //convert ArrayList to Array using shallow copy
        Person[] pArray = pList.toArray(new Person[0]);

        System.out.println("Original List = " + pList);
        System.out.println("Array from ArrayList = " + Arrays.toString(pArray));

        //let's change the list and array
        pList.get(0).setName("David");
        pArray[1].setName("Peter");

        System.out.println("Modified List = " + pList);
        System.out.println("Modified Array = " + Arrays.toString(pArray));
    }

    private static void deepCopy() {
        System.out.println("Deep copy example:");

        Person p1 = new Person("Johnny");
        Person p2 = new Person("Sean");

        List<Person> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);

        //convert ArrayList to Array using deep copy
        Person[] pArray = new Person[pList.size()];

        for (int i = 0; i < pList.size(); i++) {
            Person p = pList.get(i);
            Person temp = new Person(p.getName());
            pArray[i] = temp;
        }

        System.out.println("Original List = " + pList);
        System.out.println("Array from ArrayList = " + Arrays.toString(pArray));

        //let's change the list and array
        pList.get(0).setName("David");
        pArray[1].setName("Peter");

        System.out.println("Modified List = " + pList);
        System.out.println("Modified Array = " + Arrays.toString(pArray));
    }
}


