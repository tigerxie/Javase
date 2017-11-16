package com.ericsson.upg.pattern.visitor;

public interface ComputerPart {

    public void accept(ComputerVisitor computerPartVisitor);
}
