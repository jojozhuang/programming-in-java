package johnny.java.core.comparator;

import java.util.Arrays;

public class ComparatorExample {
    public static void main(String[] args) {
        // Create object array
        Employee[] empArr = new Employee[3];
        empArr[0] = new Employee(10, "Johnny", 21, 5000);
        empArr[1] = new Employee(5, "George", 40, 4000);
        empArr[2] = new Employee(1, "Terry", 33, 7000);

        // Sort employee array using Comparable interface implementation
        Arrays.sort(empArr);
        System.out.println("Sort employee list with default Comparable interface:\n" + Arrays.toString(empArr));

        // Sort employee with custom comparator based on age
        Arrays.sort(empArr, Employee.AgeComparator);
        System.out.println("Sort employee list with custom Comparator interface(on Age):\n" + Arrays.toString(empArr));

        // Sort employee with custom comparator based on salary
        Arrays.sort(empArr, new SalaryComparator());
        System.out.println("Sort employee list with custom Comparator interface(on Salary):\n" + Arrays.toString(empArr));
    }
}
