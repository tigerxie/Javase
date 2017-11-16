package currency.wait;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaitThread2 implements Runnable {

    WaitThread1 wThread1 = null;

    public WaitThread2(WaitThread1 wThread1) {
        this.wThread1 = wThread1;
    }

    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            synchronized (wThread1) {
                System.out.println(Thread.currentThread() + "sleep 2s then notify");
                wThread1.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService eService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            WaitThread1 wThread1 = new WaitThread1();
            eService.execute(wThread1);
            eService.execute(new WaitThread2(wThread1));
        }
        TimeUnit.SECONDS.sleep(5);
        eService.shutdown();
    }
}
