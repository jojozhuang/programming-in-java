package johnny.java.formatting;

public class IntFormatting {
    public void format() {
        int population = 123456;
        // 5) Print an "int" ­ Left Justified, No field width, with various formatting
        System.out.format("%d%n", population);     // Results >123456   [Left Justified] 
        System.out.format("%+d%n", population);    // Results >+123456  [Left Justified, displays "+" for positive values]
        System.out.format("%,d%n", population);    // Results >123,456  [Left Justified, Inserts commas where appropriate]
        System.out.format("$%,d%n", population);   // Results >$123,456 [Left Justified, with commas -­ preceded by a "$" 
        System.out.println();
        // 6) Print an "int" ­ Left Justified, Using field width, with various formatting 
        System.out.format("%-9d%n", population);   // Results >123456   [Left Justified] 
        System.out.format("%-+9d%n", population);  // Results >+123456  [Left Justified, displays "+" for positive values]
        System.out.format("%-,9d%n", population);  // Results >123,456  [Left Justified, Inserts commas where appropriate]
        System.out.format("$%-,9d%n", population); // Results >$123,456 [Left Justified, with commas -­ preceded by a "$" 
        System.out.println();
        // 7) Print an "int" ­ Right Justified, Using field width, with various formatting 
        System.out.format("%9d%n", population);    // Results >   123456 [Right Justified] 
        System.out.format("%+9d%n", population);   // Results >  +123456 [Right Justified, displays "+" for positive values]
        System.out.format("%,9d%n", population);   // Results >  123,456 [Right Justified, Inserts commas where appropriate]
        System.out.format("%09d%n", population);   // Results >000123456 [Right Justified, padds blanks with Zeros] 
        System.out.println();
    }
}
