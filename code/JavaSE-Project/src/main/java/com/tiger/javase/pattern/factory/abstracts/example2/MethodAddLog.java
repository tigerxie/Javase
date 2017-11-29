package com.tiger.javase.pattern.factory.abstracts.example2;

import java.lang.reflect.Method;

public class MethodAddLog {
    public static void main(String[] args) throws ClassNotFoundException {
        Class lazz = Class.forName("com.tiger.javase.pattern.factory.abstracts.example2.ProductA1");
        Method[] methods = lazz.getDeclaredMethods();
        // Method[] methods = lazz.getMethods();
        for (Method method : methods) {
            System.out.println(method.toString());
        }
    }
}
