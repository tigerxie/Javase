package com.ericsson.upg.pattern.factory.method.example2;

public class ConcreteFactory1 implements Factory {

    private static ConcreteFactory1 instance = null;

    private ConcreteFactory1() {
    }

    public static ConcreteFactory1 getInstance() {
        if (instance == null) {
            instance = new ConcreteFactory1();
        }
        return instance;
    }

    public Product getProduct() {
        return new Product1();
    }

}
