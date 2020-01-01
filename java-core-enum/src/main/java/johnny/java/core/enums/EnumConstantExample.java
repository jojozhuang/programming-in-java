package johnny.java.core.enums;

public class EnumConstantExample {

    class PriorityConstant {
        public static final int LOW = 1;
        public static final int MEDIUM = 2;
        public static final int HIGH = 3;
    }

    enum PriorityEnum {
        LOW,
        MEDIUM,
        HIGH
    }

    public static void main(String[] args) {
        // using enum
        enumLoop();
        // Compare the difference between Enum and Constant
        enumVsConstants();
    }

    private static void enumLoop() {
        PriorityEnum prt = PriorityEnum.MEDIUM;
        System.out.println(prt);

        // Enum in a Switch Statement
        switch (prt) {
            case LOW:
                System.out.println("Low level");
                break;
            case MEDIUM:
                System.out.println("Medium level");
                break;
            case HIGH:
                System.out.println("High level");
                break;
        }

        // Loop Through an Enum
        for (PriorityEnum penum : PriorityEnum.values()) {
            System.out.println(penum);
        }
    }

    private static void enumVsConstants() {
        //Enum values are fixed
        enumExample(PriorityEnum.LOW);
        enumExample(PriorityEnum.MEDIUM);
        enumExample(PriorityEnum.HIGH);
        enumExample(null);

        constantsExample(1);
        constantsExample(2);
        constantsExample(3);
        //we can pass any int constant
        constantsExample(4);
    }

    private static void enumExample(PriorityEnum p) {
        if (p == PriorityEnum.LOW) {
            System.out.println("Low level");
        } else if (p == PriorityEnum.MEDIUM) {
            System.out.println("Medium level");
        } else if (p == PriorityEnum.HIGH) {
            System.out.println("High level");
        } else {
            System.out.println("Invalid input!");
        }
    }

    private static void constantsExample(int p) {
        if (p == PriorityConstant.LOW) {
            System.out.println("Low level");
        } else if (p == PriorityConstant.MEDIUM) {
            System.out.println("Medium level");
        } else if (p == PriorityConstant.HIGH) {
            System.out.println("High level");
        } else {
            System.out.println("Invalid input!");
        }
    }
}
