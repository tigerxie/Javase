package currency.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitNotify implements Runnable {

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            MySignal.setHasDataToProcess(true);
            MyWaitNotify.doNotify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        WaitNotify wNotify = new WaitNotify();
        WaitNotify2 wNotify2 = new WaitNotify2();

        ExecutorService eService = Executors.newCachedThreadPool();
        eService.execute(wNotify2);
        eService.execute(wNotify);
    }
}

class WaitNotify2 implements Runnable {

    public void run() {
        MyWaitNotify.doWait();
        if (MySignal.isHasDataToProcess()) {
            System.out.println("mark set ture to false.");
            MySignal.setHasDataToProcess(false);
        }
    }
}

class MonitorObject {
}

class MyWaitNotify {
    static MonitorObject mObject = new MonitorObject();
    static boolean wasSignalled = false;

    public static void doWait() {
        synchronized (mObject) {
            // if (!wasSignalled) {
            while (!wasSignalled) {
                try {
                    mObject.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // clear signal and continue running.
        wasSignalled = false;
    }

    public static void doNotify() {
        synchronized (mObject) {
            wasSignalled = true;
            mObject.notify();
        }
    }
}
