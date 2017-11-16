package currency.wait.notify.pattern;

public class WaitAndNotify {

    public static void main(String[] args) {
        Person person = new Person();
        new Thread(new Producter("Producter 1", person)).start();
        new Thread(new Producter("Producter 2", person)).start();
        new Thread(new Producter("Producter 3", person)).start();
        new Thread(new Consumer("Consumer 1", person)).start();
        new Thread(new Consumer("Consumer 2", person)).start();
        new Thread(new Consumer("Consumer 3", person)).start();
    }
}

class Producter implements Runnable {

    private Person person;
    private String name;

    public Producter(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + name);
                person.produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private Person person;
    private String name;

    public Consumer(String name, Person person) {
        this.name = name;
        this.person = person;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + name);
                person.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Person {
    private int productCount = 0;
    private Object lockObj = new Object();
    private final int MAX_COUNT = 5;

    public void produce() throws InterruptedException {
        synchronized (lockObj) {
            while (productCount == MAX_COUNT) {
                System.out.println("produce wait. productCount=" + productCount);
                lockObj.wait();
            }
            ++productCount;
            System.err.println("produce productCount=" + productCount);
            lockObj.notifyAll();
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lockObj) {
            while (productCount == 0) {
                System.out.println("consume wait. productCount=" + productCount);
                lockObj.wait();
            }
            --productCount;
            System.err.println("produce productCount=" + productCount);
            lockObj.notifyAll();
        }
    }
}
