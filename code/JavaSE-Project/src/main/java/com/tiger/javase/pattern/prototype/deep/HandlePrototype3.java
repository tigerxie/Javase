package com.tiger.javase.pattern.prototype.deep;

public class HandlePrototype3 implements Cloneable {

    private String id;
    private Prototype3 prototype3;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        HandlePrototype3 handlePrototype3 = null;
        handlePrototype3 = (HandlePrototype3) super.clone();
        handlePrototype3.prototype3 = (Prototype3) this.prototype3.clone();
        return handlePrototype3;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Prototype3 getPrototype3() {
        return prototype3;
    }

    public void setPrototype3(Prototype3 prototype3) {
        this.prototype3 = prototype3;
    }
}
