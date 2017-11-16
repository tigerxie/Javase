package currency.wait.notify.pattern;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class AwaitAndSignal {

    public static void main(String[] args) {
        Person1 person = new Person1();
        new Thread(new Producter1("Producter 1", person)).start();
        new Thread(new Producter1("Producter 2", person)).start();
        new Thread(new Producter1("Producter 3", person)).start();
        new Thread(new Consumer1("Consumer 1", person)).start();
        new Thread(new Consumer1("Consumer 2", person)).start();
        new Thread(new Consumer1("Consumer 3", person)).start();
    }
}

class Producter1 implements Runnable {

    private Person1 person;
    private String name;

    public Producter1(String name, Person1 person) {
        this.name = name;
        this.person = person;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + name);
            person.produce();
        }
    }
}

class Consumer1 implements Runnable {

    private Person1 person;
    private String name;

    public Consumer1(String name, Person1 person) {
        this.name = name;
        this.person = person;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + name);
            person.consume();
        }
    }
}

class Person1 {
    private int productCount = 0;
    private final int MAX_COUNT = 5;
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            while (productCount == MAX_COUNT) {
                System.out.println("produce await. productCount=" + productCount);
                condition.await();
            }
            ++productCount;
            System.err.println("produce productCount=" + productCount);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            while (productCount == 0) {
                System.out.println("consume await. productCount=" + productCount);
                condition.await();
            }
            --productCount;
            System.err.println("produce productCount=" + productCount);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
