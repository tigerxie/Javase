package com.tiger.javase.pattern.visitor;

public class Displayer implements ComputerPart {

    public void accept(ComputerVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

}
