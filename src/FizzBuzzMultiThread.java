import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzMultiThread {
    private int n;
    private AtomicInteger current;
    private BlockingQueue<String> queue;

    public FizzBuzzMultiThread(int n){
        this.n = n;
        this.current = new AtomicInteger(1);
        this.queue = new LinkedBlockingQueue<>();
    }

    public void fizz(){
        while (true){
            int num = current.get();
            if (num > n) break;
            if(num % 3 == 0 & num % 5 != 0){
                queue.add("fizz");
                current.incrementAndGet();
            }
        }
    }

    public void buzz(){
        while (true){
            int num = current.get();
            if (num > n) break;
            if(num % 3 != 0 & num % 5 == 0){
                queue.add("buzz");
                current.incrementAndGet();
            }
        }
    }

    public void fizzbuzz(){
        while (true){
            int num = current.get();
            if (num > n) break;
            if(num % 3 == 0 & num % 5 == 0){
                queue.add("fizzbuzz");
                current.incrementAndGet();
            }
        }
    }

    public void number(){
        while (true){
            int num = current.get();
            if (num > n) break;
            if(num % 3 != 0 & num % 5 != 0){
                queue.add(String.valueOf(num));
                current.incrementAndGet();
            }
        }
    }

    public void printQueue() {
        while (queue.size() > 0 || current.get() <= n) {
            String output = queue.poll();
            if (output != null) {
                System.out.print(output + ", ");
            }
        }
    }

    public static void main(String[] args) {
        FizzBuzzMultiThread fizzbuzzThread = new FizzBuzzMultiThread(25);

        Thread fizz = new Thread(fizzbuzzThread::fizz);
        Thread buzz = new Thread(fizzbuzzThread::buzz);
        Thread fizzbuzz = new Thread(fizzbuzzThread::fizzbuzz);
        Thread number = new Thread(fizzbuzzThread::number);
        Thread printer = new Thread(fizzbuzzThread::printQueue);

        fizz.start();
        buzz.start();
        fizzbuzz.start();
        number.start();
        printer.start();

        try {
            fizz.join();
            buzz.join();
            fizzbuzz.join();
            number.join();
            printer.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}
