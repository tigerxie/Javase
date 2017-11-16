package com.ericsson.upg.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TimeDelay {
    static class DelayTaskThread extends Thread {
        Map<String, String> res;

        public DelayTaskThread(Map<String, String> res) {
            super();
            this.res = res;
        }

        @Override
        public void run() {
            fetchScheme(res);
            fetchBackup(res);
        }

    }

    public static void fetchScheme(Map<String, String> res) {
        sleep(1);
        System.out.println("fetchScheme begin");
        int total = 100;
        int per = new Random().nextInt(10);
        res.put("Scheme_time", String.valueOf(total));
        res.put("Scheme_per", String.valueOf(per));

        while (total > 0) {
            total -= per;
            per = new Random().nextInt(10);
            sleep(1);
        }

        res.put("Scheme", "Success");
        System.out.println("fetchScheme end");
    }

    public static void fetchBackup(Map<String, String> res) {
        System.out.println("fetchBackup begin");
        int total = 1000;
        int per = new Random().nextInt(50);
        res.put("Backup_time", String.valueOf(total));
        res.put("Backup_per", String.valueOf(per));
        while (total > 0) {
            total -= per;
            per = new Random().nextInt(50);
            sleep(1);
        }
        res.put("Backup", "Success");
        System.out.println("fetchBackup end");
    }

    public static void execute() {
        Map<String, String> res = new HashMap<>();
        res.put("Scheme", "NONE");
        res.put("Backup", "NONE");

        Thread delay = new DelayTaskThread(res);
        delay.start();
        printProgress(res);
    }

    private static void printProgress(Map<String, String> res) {
        System.out.println("Initial loading");
        System.out.println("Total time is amost " + ((100 / 5) + (1000 / 20)) + "s");
        String str = null;

        int per = 0;
        int total = 1100;
        int count = 0;
        while (!checkAllReceived(res)) {
            str = ".";
            System.out.print(str);
            sleep(1);

            if (per > 100) {
                per += 20;
            } else {
                per += 5;
            }

            if (checkAllReceived(res)) {
                System.out.print("100(100)");
                continue;
            }

            if (++count % 10 == 0) {
                if (per > total) {
                    System.out.print("99(100)");
                } else {
                    System.out.print(String.valueOf((100 * per) / total) + "(100)");
                }
                if (count % 40 == 0) {
                    System.out.println();
                }
            }
        }
    }

    private static boolean checkAllReceived(Map<String, String> res) {
        for (Map.Entry<String, String> entry : res.entrySet()) {
            if ("NONE".equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    private static void sleep(int time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        execute();
        // Random random = new Random();
        // for (int i = 0; i < 10; i++) {
        // System.out.println(random.nextInt(100));
        // }
    }
}
