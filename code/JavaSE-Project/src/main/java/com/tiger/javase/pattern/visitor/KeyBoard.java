package com.ericsson.upg.pattern.visitor;

public class KeyBoard implements ComputerPart {

    public void accept(ComputerVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
