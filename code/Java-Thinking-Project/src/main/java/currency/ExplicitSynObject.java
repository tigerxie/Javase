package currency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitSynObject {

    public static void main(String[] args) throws InterruptedException {
        final ExplicitMultiSynch multiSynch = new ExplicitMultiSynch();
        ExecutorService eService = Executors.newCachedThreadPool();
        eService.execute(new Runnable() {

            public void run() {
                try {
                    multiSynch.f2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
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

class ExplicitMultiSynch {
    // Lock lock = new ReentrantLock();

    public synchronized void f1() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("f1 **********");
            }
        } finally {
            lock.unlock();
        }
    }

    public void f2() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("f2 ++");
            }
        } finally {
            lock.unlock();
        }

    }

    public void f3() throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {
                Thread.yield();
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("f3");
            }
        } finally {
            lock.unlock();
        }
    }
}