package com.ericsson.upg.pattern.visitor;

public class ComputerPartVisitor implements ComputerVisitor {

    public void visit(Computer computer) {
        System.out.println("computer: " + computer.toString());
    }

    public void visit(Mouse mouse) {
        System.out.println("mouse: " + mouse.toString());
    }

    public void visit(KeyBoard keyBoard) {
        System.out.println("keyBoard: " + keyBoard.toString());
    }

    public void visit(Displayer displayer) {
        System.out.println("displayer: " + displayer.toString());
    }
}
