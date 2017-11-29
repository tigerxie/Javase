package com.tiger.javase.pattern.prototype.deep;

import java.io.IOException;

public class NewPrototypeSeDemo {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        PrototypeSe po = new PrototypeSe();
        po.setName("test1");
        NewPrototypeSe se = new NewPrototypeSe();
        se.setPrototype(po);

        NewPrototypeSe deepClone = (NewPrototypeSe) se.deepClone();
        deepClone.getPrototype().setName("test2");

        System.out.println("original name:" + se.getPrototype().getName());
        System.out.println("cloned name:" + deepClone.getPrototype().getName());

    }
}
