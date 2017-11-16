package com.ericsson.upg.pattern.visitor;

public class Computer implements ComputerPart {

    private ComputerPart[] computerParts;

    public Computer() {
        computerParts = new ComputerPart[] { new Mouse(), new KeyBoard(), new Displayer() };
    }

    public void accept(ComputerVisitor computerPartVisitor) {
        for (ComputerPart computerPart : computerParts) {
            computerPart.accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
