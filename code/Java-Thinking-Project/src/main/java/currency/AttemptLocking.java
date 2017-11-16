package currency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {
    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock():" + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void time() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("2 tryLock():" + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking att = new AttemptLocking();
        att.untimed();
        att.time();
        new Thread() {
            {
                setDaemon(true);
            }

            @Override
            public void run() {
                att.lock.lock();
                System.out.println("acquired");
            }
        }.start();
        Thread.yield();
        att.untimed();
        att.time();
    }
}
