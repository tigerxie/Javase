package currency.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BusyWait implements Runnable {

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
            MySignal.setHasDataToProcess(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BusyWait bWait = new BusyWait();
        BusyWait2 busyWait2 = new BusyWait2();

        ExecutorService eService = Executors.newCachedThreadPool();
        eService.execute(busyWait2);
        eService.execute(bWait);
    }
}

class BusyWait2 implements Runnable {

    public void run() {
        Long start = System.currentTimeMillis();
        while (!MySignal.isHasDataToProcess()) {
        }
        Long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("mark set ture to false.");
        MySignal.setHasDataToProcess(false);
    }
}

class MySignal {
    private static boolean hasDataToProcess = false;

    public static synchronized boolean isHasDataToProcess() {
        return hasDataToProcess;
    }

    public static synchronized void setHasDataToProcess(boolean hasDataToProcess) {
        MySignal.hasDataToProcess = hasDataToProcess;
    }
}