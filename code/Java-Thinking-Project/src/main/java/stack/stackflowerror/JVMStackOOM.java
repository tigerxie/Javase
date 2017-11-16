package stack.stackflowerror;

public class JVMStackOOM {

    private void threadMethod() {
        while (true) {

        }
    }

    private void stackLeakBYThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    threadMethod();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JVMStackOOM jvmStackOOM = new JVMStackOOM();
        jvmStackOOM.stackLeakBYThread();
    }
}
