package johnny.java.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinExample {
    static final int size = 10000;
    public static void main(String[] args) {
        double[] numbers = new double[size];
        // generate random numbers
        for (int i = 0; i < size; i++) {
            numbers[i] = Math.random();
        }
        Counter counter = new Counter(numbers, 0, numbers.length, x->x > 0.5);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(counter); // Performs the given task, returning its result upon completion.
        System.out.println(counter.join()); // output: 500305
    }
}
