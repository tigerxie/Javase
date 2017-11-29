package com.tiger.javase.pattern.factory.abstracts.example1;

import com.tiger.javase.pattern.factory.simple.Shape;

public class FactoryProductorDemo {

    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProductor.getFactory("Shape");
        Shape shape = shapeFactory.getShape("Circle");
        shape.draw();

        AbstractFactory colorFactory = FactoryProductor.getFactory("Color");
        Color color = colorFactory.getColor("Blue");
        color.fill();
    }
}
