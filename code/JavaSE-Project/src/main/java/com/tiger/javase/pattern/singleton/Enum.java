package com.ericsson.upg.pattern.singleton;

public enum Enum {

    INSTANCE;

    {
        System.out.println("-----");
    }
    public static void main(String[] args) {
    }
}
