public class Main {
    public static void main(String[] args) {
        ThreadTime threadTime = new ThreadTime();

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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadTime.sec.start();
        threadTime.fiveSec.start();
    }
}