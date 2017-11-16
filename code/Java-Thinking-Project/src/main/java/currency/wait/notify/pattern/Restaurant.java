package currency.wait.notify.pattern;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Restaurant {

    Meal meal;
    ExecutorService eService = Executors.newCachedThreadPool();
    Chef chef = new Chef(this);
    WaitPerson waitPerson = new WaitPerson(this);

    public Restaurant() {
        eService.execute(chef);
        eService.execute(waitPerson);
    }

    public static void main(String[] args) {
        new Restaurant();
    }
}

class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "order:" + orderNum;
    }
}

class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {

    }
}

class Chef implements Runnable {

    private Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void run() {

    }
}
