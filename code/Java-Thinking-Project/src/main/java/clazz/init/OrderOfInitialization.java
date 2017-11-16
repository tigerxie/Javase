package clazz.init;

public class OrderOfInitialization {
    public static void main(String[] args) {
        House house = new House();
        house.f();
    }
}

class House {
    Door door1 = new Door(1);

    public House() {
        System.out.println("House constructor");
        door3 = new Door(33);
    }

    public void f() {
        door2 = new Door(22);
    };

    Door door2 = new Door(2);
    Door door3 /* = new Door(3) */;
}

class Door {
    public Door(int i) {
        System.out.println("door constructor: " + i);
    }
}