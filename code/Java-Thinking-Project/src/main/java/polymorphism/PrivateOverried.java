package polymorphism;

public class PrivateOverried {

    private void f() {
        System.out.println("private f");
    }

    public static void main(String[] args) {
        PrivateOverried privateOverried = new Derived();
        privateOverried.f();
    }
}

class Derived extends PrivateOverried {
    public void f() {
        System.out.println("public f");
    }
}
