package clazz.init;

public class Mugs {
    public static void main(String[] args) {
        new Mug();
        new Mug(1);
    }
}

class Mug {
    public Mug() {
    }

    Mug(int i) {

    }

    {
        System.out.println("code block");
    }

    void printArray(Object... objects) {

    }

    void printArray0(Integer... integers) {

    }
}
