package currency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadMethod2 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int number = 10;
        Future<Integer> future = runTask(number);
        System.out.println(future.get());
    }

    private static Callable<Integer> t;

    private static int getFibo(int i) {
        if (i == 1 || i == 2)
            return 1;
        else
            return getFibo(i - 1) + getFibo(i - 2);
    }

    private static Future<Integer> runTask(final int count) {
        t = new Callable<Integer>() {
            public Integer call() throws Exception {
                return getFibo(count);
            }
        };
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> future = exec.submit(t);
        exec.shutdown();
        return future;
    }
}
