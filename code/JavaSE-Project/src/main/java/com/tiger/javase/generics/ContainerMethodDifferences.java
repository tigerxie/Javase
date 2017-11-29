package com.tiger.javase.generics;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodDifferences {

    public static Set<String> methodSet(Class<?> type) {
        Set<String> set = new TreeSet<String>();
        Method[] methods = type.getMethods();
        for (Method method : methods) {
            set.add(method.getName());
        }
        return set;
    }

    public static void interfaces(Class<?> type) {
        System.out.println("Interface in " + type.getSimpleName() + ":");
        ArrayList<String> result = new ArrayList<String>();
        Class<?>[] classes = type.getInterfaces();
        for (Class<?> class1 : classes) {
            result.add(class1.getSimpleName());
        }
        System.out.println(result.toString());
    }

    private static Set<String> objectMethods = methodSet(Object.class);

    static {
        objectMethods.add("clone");
    }

    public static void different(Class<?> superset, Class<?> subset) {
        System.out.println(superset.getSimpleName() + " extends " + subset.getSimpleName() + " , adds: ");
        Set<String> comp = Sets.different(methodSet(superset), methodSet(subset));
        comp.remove(objectMethods);
        System.out.println(comp);
    }

    public static void main(String[] args) {
        System.out.println("method set : " + methodSet(Collection.class));
        interfaces(Collection.class);
        different(Set.class, Collection.class);
        different(LinkedHashSet.class, HashSet.class);
        different(List.class, Collection.class);
        different(List.class, Iterator.class);

    }
}
