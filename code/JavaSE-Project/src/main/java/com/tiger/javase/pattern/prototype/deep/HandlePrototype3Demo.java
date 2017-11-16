package com.ericsson.upg.pattern.prototype.deep;

public class HandlePrototype3Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        HandlePrototype3 handlePrototype3 = new HandlePrototype3();
        handlePrototype3.setId("hpid3");
        Prototype3 prototype3 = new Prototype3();
        prototype3.setId("pid3");
        prototype3.setName("pname3");
        handlePrototype3.setPrototype3(prototype3);

        HandlePrototype3 handlePrototypeClone = (HandlePrototype3) handlePrototype3.clone();
        handlePrototypeClone.setId("hpidClone");
        handlePrototypeClone.getPrototype3().setId("pidClone");
        handlePrototypeClone.getPrototype3().setName("pnameClone");

        System.out.println(
                "handlePrototype3: " + handlePrototype3.getId() + handlePrototype3.getPrototype3().getId() + handlePrototype3.getPrototype3().getName());

        System.err.println("handlePrototypeClone:" + handlePrototypeClone.getId() + handlePrototypeClone.getPrototype3().getId()
                + handlePrototypeClone.getPrototype3().getName());
    }
}
