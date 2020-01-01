package johnny.java.core.basic;

public class StringBuilderExample {
    public static void main(String[] args)
    {
        // StringBuilder creation
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder(20);     // Set capacity
        StringBuilder sb3 = new StringBuilder("Hello, world!"); // Creation with initial value

        StringBuilder sb = new StringBuilder("Have");
        // append
        sb.append(" a");
        sb.append(" nice");
        sb.append(" day!");
        System.out.println(sb); // sb.toString() = "Have a nice day!"
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb); // sb.toString() = "Have a nice day!123"

        // insert
        sb.insert(0, "Johnny, ");
        System.out.println(sb); // sb.toString() = "Johnny, Have a nice day!123"

        // replace
        sb.replace(8, 12, "have"); // change H to lower case
        System.out.println(sb); // sb.toString() = "Johnny, have a nice day!123"

        // delete
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb); // sb.toString() = "Johnny, have a nice day!1"

        // Delete last character
        sb.setLength(sb.length() - 1);
        System.out.println(sb); // sb.toString() = "Johnny, have a nice day!"

        // reverse
        sb.reverse();
        System.out.println(sb); // sb.toString() = "!yad ecin a evah ,ynnhoJ"

        // convert to String
        String str = sb.toString();
        System.out.println(str); // str = "!yad ecin a evah ,ynnhoJ";
    }
}
