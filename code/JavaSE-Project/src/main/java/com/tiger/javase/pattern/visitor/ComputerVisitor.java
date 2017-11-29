package com.tiger.javase.pattern.visitor;

public interface ComputerVisitor {

    public void visit(Computer computer);

    public void visit(Mouse mouse);

    public void visit(KeyBoard keyBoard);

    public void visit(Displayer displayer);
}
