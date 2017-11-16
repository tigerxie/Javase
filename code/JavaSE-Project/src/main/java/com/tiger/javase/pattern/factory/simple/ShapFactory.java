package com.ericsson.upg.pattern.factory.simple;

public class ShapFactory {

    public Shape getShap(String name) {
        if (name.equals("Circle")) {
            return new Circle();
        } else if (name.equals("Square")) {
            return new Square();
        }
        return null;
    }
}
