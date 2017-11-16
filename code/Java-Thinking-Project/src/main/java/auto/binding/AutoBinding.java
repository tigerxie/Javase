package auto.binding;

public class AutoBinding {
    static int i = 0;

    public static void main(String[] args) {
        // int i = 1;
        // System.out.println(i);

        Father sFather = new Son();
        sFather.f1();
        char c = 'a';
        sFather.f2(c);
        sFather.f3(null);
    }
}

class Father {
    public void f1() {
        System.out.println("Father f1.");
    }

    public void f2(int i) {
        System.out.println("Father f2. " + i);
    }

    public void f3(Object o) {
        System.out.println("Father f3(Object o). " + o);
    }

    // public void f3(char[] c) {
    // System.out.println("Father f3(char[] c). ");
    // }

    public void f3(int[] i) {
        System.out.println("Father f3(int[] i). " + i);
    }
}

class Son extends Father {
    public void f1() {
        System.out.println("Son f1.");
    }

    public void f2(char c) {
        System.out.println("Son f2. " + c);
    }
}
