package com.tiger.javase.jvm.classloader;

public class MyClassLoader {

	final void fun() {

	}

	public static void main(String[] args) {
		int a;
		// System.out.println(a);
		ClassLoader classLoader = new ClassLoader() {
			@Override
			protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
				Class<?> class1 = findLoadedClass(name);
				if (class1 == null) {
					if (getParent() != null) {
						class1 = getParent().loadClass(name);
					} else {
						// findBootstrapClassOrNull(name);
					}
				}
				return null;
			}
		};
	}

}
