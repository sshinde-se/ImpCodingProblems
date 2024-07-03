package Java_Imp;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/*
The run() method in the Runnable interface does not return a value because it has a void return type.
If you need to return a result from a task that is executed in a separate thread,
you can use the Callable<V> interface instead of Runnable
 */
public class ReturnValueFromRunMethod {
    public static void main(String[] args) {
        // Create a callable task
        Callable<String> callableTask = new Callable<String>() {
            @Override
            public String call() throws Exception {
                // Simulate some computation or task
                Thread.sleep(500); // Simulate some work
                return "Task completed!";
            }
        };

        // Create an ExecutorService
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit the callable task to the executor service
        Future<String> futureResult = executorService.submit(callableTask);

        try {
            // Retrieve the result of the callable task
            String result = futureResult.get(); // This will block until the result is available
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shut down the executor service
            executorService.shutdown();
        }
    }
}
