package com.ericsson.upg.pattern.factory.method.example2;

public class ConcreteFactoryDemo {
    public static void main(String[] args) {
        ConcreteFactory1 concreteFactory1 = ConcreteFactory1.getInstance();
        ConcreteFactory1 concreteFactory11 = ConcreteFactory1.getInstance();
        Product product = concreteFactory1.getProduct();
        product.method1();
        System.out.println(concreteFactory1.toString());
        System.out.println(concreteFactory11.toString());
    }
}
