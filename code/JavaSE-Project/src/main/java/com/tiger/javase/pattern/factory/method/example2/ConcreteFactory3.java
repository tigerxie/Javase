package com.tiger.javase.pattern.factory.method.example2;

public class ConcreteFactory3 implements Factory {

    public Product getProduct() {
        return new Product3();
    }

}
