import java.util.concurrent.atomic.AtomicInteger;

public class Ex {
    static int atomicInteger =  0;

    public static void increment() {
        atomicInteger++;
    }

    public static void main(String[] args) throws InterruptedException {
Thread thread1 = new Thread(new MyRunnable());
Thread thread2 = new Thread(new MyRunnable());
thread1.start();
thread2.start();
thread1.join();
thread2.join();

        System.out.println("Konec");
        System.out.println(atomicInteger);
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i<1000; i++) {
            Ex.increment();
        }
    }
}