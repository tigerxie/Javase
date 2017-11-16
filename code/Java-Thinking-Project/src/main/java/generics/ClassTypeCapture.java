package generics;

import java.util.HashMap;
import java.util.Map;

public class ClassTypeCapture<T> {

    private Class<T> type;

    private Map<String, Class<T>> map = new HashMap<String, Class<T>>();

    public void addType(String typename, Class<T> kind) {
        map.put(typename, kind);
    }

    public T createNew(String typename) {
        try {
            return map.get(typename).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ClassTypeCapture(Class<T> clazz) {
        this.type = clazz;
    }

    public boolean f(Object obj) {
        return type.isInstance(obj);
    }

    public static void main(String[] args) {
        ClassTypeCapture<Inner> classTypeCapture = new ClassTypeCapture<Inner>(Inner.class);
        System.out.println(classTypeCapture.f(new Inner()));

        String typeName = "inner";
        ClassTypeCapture<Inner> classTypeCapture1 = new ClassTypeCapture<Inner>(Inner.class);
        classTypeCapture1.addType(typeName, Inner.class);
        Inner inner = classTypeCapture1.createNew(typeName);
        inner.method();

        String typeName1 = "integer";
        ClassTypeCapture<Integer> classTypeCapture2 = new ClassTypeCapture<Integer>(Integer.class);
        classTypeCapture2.addType(typeName1, Integer.class);
        Integer integer = classTypeCapture2.createNew(typeName1);
        System.out.println(integer);
    }

    static class Inner {
        public void method() {
            System.out.println("inner method.");
        }
    }
}
