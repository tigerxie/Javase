package com.tiger.javase.concurrency.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestLock {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
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
                d += (Math.PI + Math.E) / (double) i;
                d += (Math.PI + Math.E) / (double) i;
                d += (Math.PI + Math.E) / (double) i;
                if (i == 100000) {
                    Thread.yield();

                }
            }
            System.out.println(this);
            if (--countDown == 0)
                return;
        }
    }
}
