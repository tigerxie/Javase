package stack.stackflowerror;

public class TestStackflowError {

    private int stackCount;

    private void stackLead() {
        stackCount++;
        stackLead();
    }

    public static void main(String[] args) {
        TestStackflowError testStackflowError = new TestStackflowError();
        try {
            testStackflowError.stackLead();
        } catch (Exception e) {
            // TODO: handle exception
            // e.printStackTrace();
            System.out.println(testStackflowError.stackCount);
        }
    }

}
