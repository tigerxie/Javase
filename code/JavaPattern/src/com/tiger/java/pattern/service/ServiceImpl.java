package com.tiger.java.pattern.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ServiceImpl<T> implements Service<T> {

    private Map<String, Stack<T>> map = null;

    public ServiceImpl() {
        map = new HashMap<>();
    }

    @Override
    public synchronized void register(String name, T t) {
        Stack<T> stack = map.get(name);
        if (stack == null) {
            stack = new Stack<T>();
            map.put(name, stack);
        }
        stack.push(t);
    }

    @Override
    public synchronized void unregister(String name) {
        Stack<T> stack = map.get(name);
        if (stack != null) {
            stack.pop();
            if (stack.size() == 0) {
                map.remove(name);
            }
        }
    }

    @Override
    public synchronized T find(String name) {
        Stack<T> stack = map.get(name);
        return stack.peek();
    }
}
