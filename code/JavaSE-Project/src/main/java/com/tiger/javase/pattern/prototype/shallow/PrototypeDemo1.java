package com.ericsson.upg.pattern.prototype.shallow;

public class PrototypeDemo1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype1 prototype = new Prototype1();
        prototype.setId("id1");
        prototype.setName("name1");

        Prototype1 prototype2 = (Prototype1) prototype.clone();
        prototype2.setId("id2");
        prototype2.setName("name2");

        System.err.println("prototype: " + prototype.getId() + prototype.getName());
        System.out.println("prototype2: " + prototype2.getId() + prototype2.getName());
    }
}
