package com.tiger.java.pattern.factory;

public class NewbornFactoryImpl<T> implements Factory<T> {

    protected T matrixInstance = null;

    public NewbornFactoryImpl(T t) {
        matrixInstance = t;
    }

    @Override
    public T getInstance() {
        if (matrixInstance != null) {
            try {
                return createObject();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private T createObject() throws InstantiationException, IllegalAccessException {
        Class<?> clazz = matrixInstance.getClass();
        Object object = clazz.newInstance();
        return (T) object;
    }
}
