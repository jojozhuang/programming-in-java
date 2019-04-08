package johnny.java.java7;

public class StringInSwitchCaseExample {
    public static void main(String args[]) {
        printColorUsingIf("red");
        printColorUsingSwitch("red");
        printColorUsingSwitch("RED");
    }

    private static void printColorUsingIf(String color) {
        if (color.equals("blue")) {
            System.out.println("BLUE");
        } else if (color.equals("red")) {
            System.out.println("RED");
        } else {
            System.out.println("INVALID COLOR CODE");
        }
    }

    private static void printColorUsingSwitch(String color) {
        switch (color) {
            case "blue":
                System.out.println("BLUE");
                break;
            case "red":
                System.out.println("RED");
                break;
            default:
                System.out.println("INVALID COLOR CODE");
        }
    }
}
