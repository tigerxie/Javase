package com.tiger.javase.pattern.visitor;

public class ComputerPartDemo {
    public static void main(String[] args) {
        ComputerVisitor computerVisitor = new ComputerPartVisitor();
        ComputerPart computerPart = new Computer();
        computerPart.accept(computerVisitor);
    }
}
