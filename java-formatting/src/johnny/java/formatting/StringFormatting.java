package johnny.java.formatting;

public class StringFormatting {
    public void format() {
        String department = "Physics";
        // 1) Print a String - no size indicator, positive size indicator, and negative size indicator 
        System.out.format("%s%n", department);    // Results >Physics [Left Justified] 
        System.out.format("%15s%n", department);  // Results > Physics [Right Justified] 
        System.out.format("%-15s%n", department); // Results >Physics [Left Justified] 
        System.out.println();
        // 2) Print a String ­- "small" size indicator, "small" size indicator with "." 
        System.out.format("%4s%n", department);  // Results >Physics [Still prints full String] 
        System.out.format("%.4s%n", department); // Results >Phys [Truncates the String] 
        System.out.println();
        // 3) Print a String report with titles ­- hard coded labels (does not line up well): 
        System.out.format("Department: %s%n", department); // Results >Department: Physics 
        System.out.format("Hobby: %s%n", department);      // Results >Hobby: Physics 
        System.out.format("Career: %s%n", department);     // Results >Career: Physics 
        System.out.println();
        // 4) Print a String report with titles ­- formatted labels (does line up well): 
        System.out.format("%-10s:%s%n", "Department", department); // Results >Department:Physics 
        System.out.format("%-10s:%s%n", "Hobby", department);      // Results >Hobby     :Physics 
        System.out.format("%-10s:%s%n", "Career", department);     // Results >Career    :Physics 
        System.out.println();
    }
}
