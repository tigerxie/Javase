package statics;

class Value3 {

    static int c = 0;

    Value3() {

        c = 15;

    }

    Value3(int i) {

        c = i;

    }

    static void inc() {

        c++;

    }

}

public class Count {

    public static void prt(String s) {

        System.out.println(s);

    }

    Value3 v = new Value3(10);

    static Value3 v1, v2;

    static {

        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);

        v1 = new Value3(27);

        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);

        v2 = new Value3(15);

        prt("v1.c=" + v1.c + "  v2.c=" + v2.c);

    }

    public static void main(String[] args) {

        Count ct = new Count();

        prt("ct.c=" + ct.v.c);

        prt("000000v1.c=" + v1.c + "  v2.c=" + v2.c);

        v1.inc();

        prt("888888v1.c=" + v1.c + "  v2.c=" + v2.c);

        prt("ct.c=" + ct.v.c);

    }

}
