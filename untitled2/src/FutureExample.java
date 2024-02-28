import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(1);

        Future<String> future = executor.submit(() -> {
            Thread.sleep(2000);
            return "Hello, Future!";
        });

        System.out.println("Waiting for the Future to complete...");

        while (!future.isDone()) {
            System.out.println("Task is not yet completed...");
            Thread.sleep(500);
        }

        String result = future.get();
        System.out.println("Future result: " + result);

        executor.shutdown();
    }
}
