package com.ericsson.upg.pattern.factory.abstracts.example1;

public class FactoryProductor {
    public static AbstractFactory getFactory(String factoryType) {
        if (factoryType == null) {
            return null;
        }
        if (factoryType.equals("Color")) {
            return new ColorFactory();
        } else if (factoryType.equals("Shape")) {
            return new ShapeFactory();
        }
        return null;
    }
}
