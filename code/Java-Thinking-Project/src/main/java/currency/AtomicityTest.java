package currency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {

    private volatile int i = 0;

    public /* synchronized */ int getValue() {
        return i;
    }

    public void run() {
        while (true) {
            eventIncrement();
        }
    }

    private synchronized void eventIncrement() {
        i++;
        i++;
    }

    public static void main(String[] args) {
        ExecutorService eService = Executors.newCachedThreadPool();
        AtomicityTest atomicityTest = new AtomicityTest();
        eService.execute(atomicityTest);
        while (true) {
            int val = atomicityTest.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }

}
