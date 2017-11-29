package com.tiger.javase.pattern.singleton;

import java.io.Serializable;

public class SingletonSe implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public static SingletonSe INSTANCE = new SingletonSe();

    protected SingletonSe() {
    }

    private Object readResolve() {
        return INSTANCE;
    }
}
