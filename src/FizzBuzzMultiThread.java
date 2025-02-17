import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzMultiThread {
    private final int number;
    private final AtomicInteger current;
    private final BlockingQueue<String> queue;

    public FizzBuzzMultiThread(int number) {
        this.number = number;
        this.current = new AtomicInteger(1);
        this.queue = new LinkedBlockingQueue<>();
    }

    public void fizz() {
        while (true) {
            int num = current.get();
            if (num > number) break;
            if (num % 3 == 0 && num % 5 != 0) {
                queue.add("fizz");
                current.incrementAndGet();
            }
        }
    }

    public void buzz() {
        while (true) {
            int num = current.get();
            if (num > number) break;
            if (num % 3 != 0 && num % 5 == 0) {
                queue.add("buzz");
                current.incrementAndGet();
            }
        }
    }

    public void fizzbuzz() {
        while (true) {
            int num = current.get();
            if (num > number) break;
            if (num % 3 == 0 && num % 5 == 0) {
                queue.add("fizzbuzz");
                current.incrementAndGet();
            }
        }
    }

    public void number() {
        while (true) {
            int num = current.get();
            if (num > number) break;
            if (num % 3 != 0 && num % 5 != 0) {
                queue.add(String.valueOf(num));
                current.incrementAndGet();
            }
        }
    }

    public void printQueue() {
        while (queue.size() > 0 || current.get() <= number) {
            String output = queue.poll();
            if (output != null) {
                System.out.print(output + ", ");
            }
        }
    }
}


