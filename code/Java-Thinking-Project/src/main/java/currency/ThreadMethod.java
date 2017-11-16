package currency;

public class ThreadMethod {

    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        t = new Thread(name) {
            public void run(String count) {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0)
                        return;
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            public String toString() {
                return getName() + " : " + countDown;
            }
        };
        t.start();
    }
}
