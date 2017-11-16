package currency;

import java.util.Timer;
import java.util.TimerTask;

public class TimerGenerator {

    public static void main(String[] args) {
        TimerGenerator timerGenerator = new TimerGenerator();
        timerGenerator.printTimer("I am tiger.", 1);
        timerGenerator.terminateTimer(1110);
        timerGenerator.newTimer(new TimerTask() {

            @Override
            public void run() {
                System.out.println("new timer");
            }
        }, 20);
        timerGenerator.printTimer("I am tiger.", 20);
        threadTestTG(timerGenerator);

    }

    private static void threadTestTG(TimerGenerator timerGenerator) {
        // final TimerGenerator tGenerator = timerGenerator;
        // ExecutorService executorService = Executors.newCachedThreadPool();
        // executorService.execute(new Runnable() {
        //
        // public void run() {
        // while (true) {
        // tGenerator.newTimer(new TimerTask() {
        //
        // @Override
        // public void run() {
        // System.out.println(this + "thread new timers");
        // }
        // }, 500);
        // }
        // }
        // });

        final TimerGenerator tGenerator = timerGenerator;
        new Thread(new Runnable() {

            public void run() {
                while (true) {
                    tGenerator.newTimer(new TimerTask() {

                        @Override
                        public void run() {
                            System.out.println(this + "thread new timers");
                        }
                    }, 500);
                }
            }
        }).start();
    }

    public void newTimer(TimerTask timerTask, long delay) {
        new Timer().schedule(timerTask, delay);
    }

    public void printTimer(String str, long delay) {
        final String string = str;
        newTimer(new TimerTask() {

            @Override
            public void run() {
                System.out.println(string);
            }
        }, delay);
    }

    public void terminateTimer(long delay) {
        newTimer(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Aborting");
                System.exit(0);
            }
        }, delay);
    }
}
