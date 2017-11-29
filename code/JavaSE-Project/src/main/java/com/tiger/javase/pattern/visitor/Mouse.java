package com.tiger.javase.pattern.visitor;

public class Mouse implements ComputerPart {

    public void accept(ComputerVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
