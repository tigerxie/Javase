package currency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SimplePriorities {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 5; i++)
            exec.execute(new TestLockThread(Thread.MIN_PRIORITY));
        exec.execute(new TestLockThread(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}

class TestLockThread implements Runnable {
    private int priority;

    private int countDown = 5;

    private volatile double d;

    public TestLockThread(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ":" + countDown;
    }

    public void run() {
        Thread.currentThread().setPriority(priority);
        while (true) {
            for (int i = 1; i <= 100000; i++) {
                d += (Math.PI + Math.E) / (double) i;
                if (i == 100) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
}

class DaemonThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        return t;
    }
}
