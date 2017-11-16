package initial;

public class Beetle extends Insert {

    private static int j = print("int j");

    private int i = print("int i");

    public Beetle() {
        System.out.println("Beetle constructor.");
        print("" + j + i);
    }

    public static void main(String[] args) {
        print("beetle");
        new Beetle();
    }

}

class Insert {
    private static int i = print("insert");

    static int print(String s) {
        System.out.println("Insert print. --> " + s);
        return 1;
    }

    public Insert() {
        System.out.println("Insert constructor.");
    }
}
