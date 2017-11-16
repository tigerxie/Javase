package com.ericsson.upg.pattern.factory.abstracts.example2;

public class ConcreteFactory2 extends AbstractFactory {

    @Override
    public ProductA getProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB getProductB() {
        return new ProductB2();
    }

}
