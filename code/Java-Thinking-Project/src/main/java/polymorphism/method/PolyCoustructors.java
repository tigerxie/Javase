package polymorphism.method;

public class PolyCoustructors {
    public static void main(String[] args) {
        new RoundGlyph(3);
    }
}

class RoundGlyph extends Glyph {
    private int i = 1;

    public RoundGlyph(int ii) {
        System.out.println("RoundGlyph constructor. " + ii);
    }

    public void raw() {
        System.out.println("RoundGlyph raw. " + i);
    }
}

class Glyph {
    public Glyph() {
        System.out.println("Glyph constructor before.");
        raw();
        System.out.println("Glyph constructor after.");
    }

    public void raw() {
        System.out.println("Glyph raw.");
    }
}