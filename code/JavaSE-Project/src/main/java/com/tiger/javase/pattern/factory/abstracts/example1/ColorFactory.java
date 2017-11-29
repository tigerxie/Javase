package com.tiger.javase.pattern.factory.abstracts.example1;

import com.tiger.javase.pattern.factory.simple.Shape;

public class ColorFactory extends AbstractFactory {

    @Override
    public Color getColor(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equals("Red")) {
            return new Red();
        } else if (colorType.equals("Black")) {
            return new Black();
        } else if (colorType.equals("Blue")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String name) {
        return null;
    }
}
