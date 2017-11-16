package com.ericsson.upg.pattern.singleton;

public class Hungry2 {

    private static Hungry2 instance = null;

    static {
        instance = new Hungry2();
    }

    private Hungry2() {
    }

    public static Hungry2 getInstance() {
        return instance;
    }
}
