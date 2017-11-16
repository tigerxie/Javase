package finall;

public class FinalMethods extends Father {

    // static final FinalMethods f;
    // private final int i;

    public static void main(String[] args) {
        new FinalMethods().method1();
    }

    public final void method1() {
        System.out.println("FinalMethods method1");
    }

    // public final void method2() {
    // System.out.println("FinalMethods method2");
    // }
}

class Father {
    private final void method1() {
        System.out.println("Father method1");
    }

    protected /* public */ final void method2() {
        System.out.println("Father method2");
    }
}