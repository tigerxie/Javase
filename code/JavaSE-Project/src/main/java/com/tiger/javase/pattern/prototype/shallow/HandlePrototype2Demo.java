package com.tiger.javase.pattern.prototype.shallow;

public class HandlePrototype2Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        HandlePrototype2 handlePrototype2 = new HandlePrototype2();
        handlePrototype2.setId("hpid1");
        Prototype2 prototype2 = new Prototype2();
        prototype2.setId("pid1");
        prototype2.setName("pname1");
        handlePrototype2.setPrototype2(prototype2);

        HandlePrototype2 handlePrototypeClone = (HandlePrototype2) handlePrototype2.clone();
        handlePrototypeClone.setId("hpid2");
        handlePrototypeClone.getPrototype2().setId("pid2");
        handlePrototypeClone.getPrototype2().setName("pname2");

        System.out.println(
                "handlePrototype2: " + handlePrototype2.getId() + handlePrototype2.getPrototype2().getId() + handlePrototype2.getPrototype2().getName());
        System.err.println("handlePrototypeClone:" + handlePrototypeClone.getId() + handlePrototypeClone.getPrototype2().getId()
                + handlePrototypeClone.getPrototype2().getName());
    }
}
