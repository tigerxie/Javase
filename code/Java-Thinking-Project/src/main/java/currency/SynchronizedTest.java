package currency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedTest {

    private String value = null;

    public void method1() {
        value = value + "A";
        Thread.yield();
        value = value + "A";
    }

    public void method2() {
        value = value + "B";
        Thread.yield();
        value = value + "B";
    }

    public synchronized String method() {
        method1();
        method2();
        return value;
    }

    public static void main(String[] args) {
        SynchronizedTest synchronizedTest = new SynchronizedTest();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new MyThread(synchronizedTest));
        }
        executorService.shutdown();
    }
}

class MyThread implements Runnable {

    private SynchronizedTest synchronizedTest = null;

    public MyThread(SynchronizedTest synchronizedTest) {
        this.synchronizedTest = synchronizedTest;
    }

    public void run() {
        // synchronizedTest.method1();
        // synchronizedTest.method2();
        String value = synchronizedTest.method();
        System.err.println(value);
    }
}
