package currency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynObject {

    public static void main(String[] args) throws InterruptedException {
        final MultiSynch multiSynch = new MultiSynch();
        ExecutorService eService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            eService.execute(new Runnable() {

                public void run() {
                    try {
                        multiSynch.f2(Thread.currentThread());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        eService.execute(new Runnable() {

            public void run() {
                try {
                    multiSynch.f3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        multiSynch.f1();
        eService.shutdown();
    }
}

class MultiSynch {
    // byte[] lock = new byte[0];
    // byte[] lock2 = new byte[0];
    Object lock = new Object();
    Object lock2 = new Object();

    public synchronized void f1() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread.yield();
            TimeUnit.MILLISECONDS.sleep(100);
            System.out.println("f1 **********");
        }
    }

    public void f2(Thread thread) throws InterruptedException {
        synchronized (lock2) {
            for (int i = 0; i < 10; i++) {
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("f2 ++: " + thread.getName());
            }
        }
    }

    public void f3() throws InterruptedException {
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("f3");
            }
        }
    }
}