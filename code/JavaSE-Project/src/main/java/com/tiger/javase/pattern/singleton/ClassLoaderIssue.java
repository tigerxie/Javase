package com.tiger.javase.pattern.singleton;

public class ClassLoaderIssue {
    public static Class<?> getClass(String className) throws ClassNotFoundException {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = ClassLoaderIssue.class.getClassLoader();
        }
        return loader.loadClass(className);
    }
}
