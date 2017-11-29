package com.tiger.javase.bytes;

/**
 * Hello world!
 *
 */
public class TestBytes {

    public static void main(String[] args) throws ClassNotFoundException {
        String str1 = "hello";

        byte[] b = str1.getBytes();
        if (b instanceof byte[]) {
            String str = new String(b);
            System.out.println(str);
        }

        System.out.println("Hello World!");
    }
}
