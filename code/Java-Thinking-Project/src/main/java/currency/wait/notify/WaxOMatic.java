package currency.wait.notify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService eService = Executors.newCachedThreadPool();
        Car car = new Car();
        WaxOn wOn = new WaxOn(car);
        WaxOff wOff = new WaxOff(car);
        eService.execute(wOn);
        eService.execute(wOff);
        TimeUnit.SECONDS.sleep(2);
        eService.shutdownNow();
    }
}

class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notify();
    }

    public synchronized void buffered() {
        waxOn = false;
        notify();
    }

    public synchronized void waitForWaxed() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }

    public synchronized void waitForBuffered() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.print("Wax on");
                car.waxed();
                car.waitForBuffered();
            }
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        System.out.println("Ending wax on task");
    }

}

class WaxOff implements Runnable {

    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.print("Wax off");
                car.buffered();
                car.waitForWaxed();
            }
        } catch (InterruptedException e) {
            System.out.println("sleep interrupted");
        }
        System.out.println("Ending wax off task");
    }

}