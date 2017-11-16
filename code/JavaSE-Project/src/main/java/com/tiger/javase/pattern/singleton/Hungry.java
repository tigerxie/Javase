package com.ericsson.upg.pattern.singleton;

public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance() {
        return instance;
    }
}
