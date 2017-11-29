package com.tiger.javase.pattern.singleton;

public class StaticInnerClass {

    private StaticInnerClass() {
    }

    private static class Singleton {
        private static StaticInnerClass INSTANCE = new StaticInnerClass();
    }

    // INSTANCE will be loaded when getInstance display to be called .
    public static StaticInnerClass getInstance() {
        return Singleton.INSTANCE;
    }
}
