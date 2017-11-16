package currency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {

    private IntGenerator generator;
    private final int id;

    public EvenChecker(IntGenerator generator, int ident) {
        this.generator = generator;
        this.id = ident;
    }

    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (!(val % 2 == 0)) {
                System.out.println(val + " event cancel");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int id) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < id; i++) {
            executorService.execute(new EvenChecker(generator, i));
        }
        executorService.shutdown();
    }

    public static void test(IntGenerator intGenerator) {
        test(intGenerator, 100);
    }

}
