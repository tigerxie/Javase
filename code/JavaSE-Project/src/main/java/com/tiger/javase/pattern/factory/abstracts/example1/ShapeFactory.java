package com.tiger.javase.pattern.factory.abstracts.example1;

import com.tiger.javase.pattern.factory.simple.Circle;
import com.tiger.javase.pattern.factory.simple.Shape;
import com.tiger.javase.pattern.factory.simple.Square;

public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equals("Circle")) {
            return new Circle();
        } else if (shapeType.equals("Square")) {
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String name) {
        return null;
    }
}
