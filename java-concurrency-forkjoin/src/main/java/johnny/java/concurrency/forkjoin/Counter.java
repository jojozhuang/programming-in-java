package johnny.java.concurrency.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class Counter extends RecursiveTask<Integer> {
    static final int THRESHOLD = 100;
    private double[] numbers;
    private int from;
    private int to;
    private Predicate<Double> filter;

    public Counter(double[] numbers, int from, int to, Predicate<Double> filter) {
        this.numbers = numbers;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        if (to - from < THRESHOLD) { // no need to split, calculate the result
            int count = 0;
            for (int i = from; i < to; i++) {
                if (filter.test(numbers[i])) {
                    count++;
                }
            }
            return count;
        } else { // split to smaller tasks
            int mid = (to - from ) / 2 + from;
            Counter first = new Counter(numbers, from, mid, filter);
            Counter second = new Counter(numbers, mid, to, filter);
            invokeAll(first, second); //
            return first.join() + second.join();
        }
    }
}