package johnny.java.lambda;

public class Calculator {
    public int operate(int a, int b, MathOperation mathOperation) {
        return mathOperation.operate(a, b);
    }
}
