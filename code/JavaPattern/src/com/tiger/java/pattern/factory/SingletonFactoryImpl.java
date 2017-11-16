package com.tiger.java.pattern.factory;

public class SingletonFactoryImpl<T> implements Factory<T> {

    protected T instance = null;

    public SingletonFactoryImpl(T t) {
        instance = t;
    }

    @Override
    public T getInstance() {
        return instance;
    }

}
