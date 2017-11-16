package com.ericsson.upg.pattern.factory.abstracts.example1;

import com.tiger.javase.pattern.factory.simple.Shape;

public abstract class AbstractFactory {
    public abstract Color getColor(String colorType);

    public abstract Shape getShape(String shapeType);
}
