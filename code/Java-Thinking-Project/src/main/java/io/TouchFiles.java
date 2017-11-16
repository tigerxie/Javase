package io;

import java.util.HashMap;

public class TouchFiles {
    private static HashMap<String, Boolean> isFirstTime = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(isFirstTime.get("a"));

        if (isFirstTime.get("a") == null || isFirstTime.get("a")) {

            System.out.println("dfsadfsadf");
        }
        isFirstTime.put("a", false);

        if (!isFirstTime.get("a")) {
            System.out.println("aaaaaaaaaa");
            System.out.println("ddd" + isFirstTime.get("a"));
        }
    }

}
