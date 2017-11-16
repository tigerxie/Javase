package com.ericsson.upg.pattern.visitor;

public class Displayer implements ComputerPart {

    public void accept(ComputerVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }

}
