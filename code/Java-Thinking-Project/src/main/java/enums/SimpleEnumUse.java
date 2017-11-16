package enums;

public class SimpleEnumUse {
    public static void main(String[] args) {
        for (Spiciness s : Spiciness.values()) {
            System.out.println("spiciness: " + s/* .toString() */ + " ordinal: " + s.ordinal());
        }
    }
}

enum Spiciness {
    NOT, MILD, MEDIUM, HOT, FLAMING
}
