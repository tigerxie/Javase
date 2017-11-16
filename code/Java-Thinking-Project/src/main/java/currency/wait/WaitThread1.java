package currency.wait;

import java.util.concurrent.TimeUnit;

public class WaitThread1 implements Runnable {

    public void run() {
        try {
            // new WaitObj().waitingCall();
            synchronized (this) {
                wait();
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread() + " be notifyed ");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WaitObj {
    public synchronized void waitingCall() throws InterruptedException {
        while (!Thread.interrupted()) {
            wait();
            System.out.println(Thread.currentThread() + " be notify ");
        }
    }
}