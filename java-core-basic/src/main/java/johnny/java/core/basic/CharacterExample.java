package johnny.java.core.basic;

public class CharacterExample {
    public static void main(String[] args) {
        // get integer value from char
        String s = "ab5d";
        int x = Character.getNumericValue(s.charAt(2)); // x = 5

        // check if character is number(one single character)
        char c = 'a';
        boolean isDigit = Character.isDigit(c);
        // same as
        if (c >= '0' && c <= '9') {
            System.out.println("c is a number");
        }

        // check if character is number or letter
        boolean isLetterOrDigit = Character.isLetterOrDigit(c);
        // same as
        if (c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            System.out.println("c is a letter or a number");
        }
    }
}
