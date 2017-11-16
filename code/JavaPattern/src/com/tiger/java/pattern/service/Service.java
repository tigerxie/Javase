package com.tiger.java.pattern.service;

public interface Service<T> {

    void register(String name, T t);

    void unregister(String name);

    T find(String name);

}
