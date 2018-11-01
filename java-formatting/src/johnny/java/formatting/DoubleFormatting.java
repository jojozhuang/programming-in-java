package johnny.java.formatting;

public class DoubleFormatting {
    public void format() {
        double price = 1234.567;
        // 8) Print a "double" ­ Left Justified, No field width, with various formatting 
        System.out.format("%f%n", price);  // Results >1234.567000  [Left Justified, 6 decimal places] 
        System.out.format("%+f%n", price); // Results >+1234.567000 [Left Justified, displays "+" for positive values, 6 decimal places]
        System.out.format("%,f%n", price); // Results >1,234.567000 [Left Justified, Inserts commas where appropriate, 6 decimal places] 
        System.out.println();
        // 9) Print a "double" ­ Left Justified (only), Using decimal­only field widths, with various formatting 
        System.out.format("%.1f%n", price); // Results >1234.6    [Left Justified, no character max, "1" decimal place] 
        System.out.format("%.2f%n", price); // Results >1234.57   [Left Justified, no character max, "2" decimal place]
        System.out.format("%.3f%n", price); // Results >1234.567  [Left Justified, no character max, "3" decimal place]
        System.out.format("%.4f%n", price); // Results >1234.5670 [Left Justified, no character max, "4" decimal place] 
        System.out.println();
        // 10) Print a "double" ­ Left Justified, Using whole number and decimal field widths, with various formatting
        System.out.format("%-12.2f%n", price);  // Results >1234.57   [Left Justified, 12 character max, 2 decimal places]
        System.out.format("%-+12.3f%n", price); // Results >+1234.567 [Left Justified, displays "+" for positive values, 12 character max, 3 decimal places]
        System.out.format("%,-12.1f%n", price); // Results >1,234.6   [Left Justified, Inserts commas where appropriate, 2 decimal place]
        System.out.println();
    }
}
