package com.tiger.javase.pattern.visitor;

public class KeyBoard implements ComputerPart {

    public void accept(ComputerVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
