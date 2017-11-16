package com.ericsson.upg.pattern.singleton;

public class Full {

    private static Full full;

    private static volatile Full full3;

    private Full() {
    }

    public static Full getInstance1() {
        if (full == null) {
            full = new Full();
        }
        return full;
    }

    public static synchronized Full getInstance2() {
        if (full == null) {
            full = new Full();
        }
        return full;
    }

    public static Full getInstance3() {
        if (full3 == null) {
            synchronized (Full.class) {
                if (full3 == null) {
                    full3 = new Full();
                }
            }
        }
        return full3;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    while (getInstance3() != null) {
                        Thread.yield();
                    }
                    System.out.println("getInstance3()==null");
                }
            }).start();
        }
    }
}
