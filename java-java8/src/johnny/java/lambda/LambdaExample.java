package johnny.java.lambda;

public class LambdaExample {
    public static void main(String args[]) {

        // with type declaration
        MathOperation addition = (int a, int b) -> a + b;

        // with out type declaration
        MathOperation subtraction = (a, b) -> a - b;

        // with return statement along with curly braces
        MathOperation multiplication = (int a, int b) -> { return a * b; };

        // without return statement and without curly braces
        MathOperation division = (int a, int b) -> a / b;

        Calculator calculator = new Calculator();
        System.out.println("10 + 5 = " + calculator.operate(10, 5, addition));
        System.out.println("10 - 5 = " + calculator.operate(10, 5, subtraction));
        System.out.println("10 x 5 = " + calculator.operate(10, 5, multiplication));
        System.out.println("10 / 5 = " + calculator.operate(10, 5, division));

        // without parenthesis
        GreetingService greetService1 = message ->
                System.out.println("Hello " + message);

        // with parenthesis
        GreetingService greetService2 = (message) ->
                System.out.println("Hello " + message);

        greetService1.sayMessage("Java8");
        greetService2.sayMessage("Lambda");
    }

}
