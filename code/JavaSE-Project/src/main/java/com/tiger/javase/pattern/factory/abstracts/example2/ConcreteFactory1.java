package com.ericsson.upg.pattern.factory.abstracts.example2;

public class ConcreteFactory1 extends AbstractFactory {

    @Override
    public ProductA getProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB getProductB() {
        return new ProductB1();
    }

}
