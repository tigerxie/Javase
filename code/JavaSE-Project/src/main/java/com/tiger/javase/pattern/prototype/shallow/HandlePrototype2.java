package com.ericsson.upg.pattern.prototype.shallow;

public class HandlePrototype2 implements Cloneable {

    private String id;
    private Prototype2 prototype2;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Prototype2 getPrototype2() {
        return prototype2;
    }

    public void setPrototype2(Prototype2 prototype2) {
        this.prototype2 = prototype2;
    }
}
