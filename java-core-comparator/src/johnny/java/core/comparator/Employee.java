package johnny.java.core.comparator;

import java.util.Comparator;

public class Employee implements Comparable<Employee> {
    private int id;
    private String name;
    private int age;
    private int salary;

    public Employee(int id, String name, int age, int salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public int compareTo(Employee emp) {
        // sort the employee based on id, in ascending order
        // return negative(less than), zero(equal to), positive(greater than)
        return (this.id - emp.id);
    }

    // Compare employee based on age.
    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.getAge() - e2.getAge();
        }
    };

    @Override
    //this is overridden to print the user-friendly information about the Employee
    public String toString() {
        return "[id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", salary=" +
                this.salary + "]";
    }
}

