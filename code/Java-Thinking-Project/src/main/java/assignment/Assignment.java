package assignment;

public class Assignment {

    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 10;
        t2.level = 20;
        System.out.println("t1:" + t1.level + " t2: " + t2.level);
        // t1 = t2;
        // solution
        t1.level = t1.level;
        System.out.println("t1:" + t1.level + " t2: " + t2.level);
        // t1.level = 30;
        t2.level = 40;
        System.out.println("t1:" + t1.level + " t2: " + t2.level);
        System.out.println(Math.round(0.3));
        System.out.println(Math.round(0.5));

        switch ("aa") {
        case "aa":
            System.out.println("hhh");
            break;

        default:
            System.out.println("ooo");
            break;
        }
    }
}

class Tank {
    int level;

    public Tank() {
        this(1);
        // this("ss");
    }

    Tank(int i) {
        // this();
        this("a");
    }

    Tank(String i) {

    }

    int method1() {
        return 0;
    }

    // method1() {
    // }
}
