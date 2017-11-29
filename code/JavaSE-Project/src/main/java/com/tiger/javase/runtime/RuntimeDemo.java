package com.tiger.javase.runtime;

public class RuntimeDemo {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());
    }
}
