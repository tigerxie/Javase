package currency;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread() + " before sleep " + this);
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("all daemon start: ");
        TimeUnit.MILLISECONDS.sleep(101);
    }
}
