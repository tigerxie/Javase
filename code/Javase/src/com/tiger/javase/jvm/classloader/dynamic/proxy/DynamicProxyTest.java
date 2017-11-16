package com.tiger.javase.jvm.classloader.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyTest {

	interface Hel {
		void hello();
	}

	static class Hello implements Hel {
		public void hello() {
			System.out.println("hello world");
		}
	}

	static class DynamicProxy implements InvocationHandler {

		Object originalObj;

		Object bind(Object obj) {
			this.originalObj = obj;
			return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
		}

		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
			System.out.println("welcome");
			return method.invoke(originalObj, args);
		}

	}

	public static void main(String[] args) {
		Hel hel = (Hel) new DynamicProxy().bind(new Hello());
		hel.hello();
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", true);
	}
}
