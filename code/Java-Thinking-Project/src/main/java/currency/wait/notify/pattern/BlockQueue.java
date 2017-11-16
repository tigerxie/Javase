package currency.wait.notify.pattern;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockQueue {

    public static void main(String[] args) {
        BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>(2);
        // BlockingDeque<String> blockingDeque1 = new LinkedBlockingDeque<String>();
        // BlockingQueue<String> blockingDeque2 = new ArrayBlockingQueue<String>(2);
        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer2(blockingDeque)).start();
            new Thread(new Producter2(blockingDeque)).start();
        }
    }
}

class Consumer2 implements Runnable {

    BlockingDeque<String> blockingDeque;

    public Consumer2(BlockingDeque<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    public void run() {
        try {
            String string = blockingDeque.take();
            System.out.println("blockingDeque take:" + string);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Producter2 implements Runnable {

    BlockingDeque<String> blockingDeque;

    public Producter2(BlockingDeque<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    public void run() {
        String string = "consuer" + Thread.currentThread().getName();
        try {
            System.out.println("blockingDeque put:" + string);
            blockingDeque.put(string);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}