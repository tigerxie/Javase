package generics;

import java.util.ArrayList;

public class ErasedTypeEquivalence {

    public static void main(String[] args) {
        Class clazz1 = new ArrayList<Integer>().getClass();
        Class clazz2 = new ArrayList<String>().getClass();
        System.out.println("clazz1: " + clazz1 + "\nclazz2: " + clazz2);
        System.out.println(clazz1 == clazz2);
    }

}
