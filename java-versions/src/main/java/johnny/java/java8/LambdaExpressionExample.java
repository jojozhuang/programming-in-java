package johnny.java.java8;

public class LambdaExpressionExample {
    public static void main(String[] args) {
        anonymousClass();
        lambdaExpression();
    }

    private static void anonymousClass() {
        Runnable r = new Runnable(){
            @Override
            public void run() {
                System.out.println("My Runnable");
            }
        };

        Thread thread = new Thread(r);
        thread.start();
    }

    private static void lambdaExpression() {
        Runnable r1 = () -> {
            System.out.println("My Runnable 1");
        };
        Thread thread1 = new Thread(r1);
        thread1.start();

        Runnable r2 = () -> System.out.println("My Runnable 2");
        Thread thread2 = new Thread(r2);
        thread2.start();
    }
}
