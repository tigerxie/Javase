package com.tiger.javase.pattern.visitor;

public interface ComputerPart {

    public void accept(ComputerVisitor computerPartVisitor);
}
