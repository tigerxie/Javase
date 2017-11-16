package com.ericsson.upg.tmp;

public class StringTest {
    @SuppressWarnings("null")
    public static void main(String[] args) {
        Object str = "";
        String str2 = (String) str;

        System.out.println(str2.length() + ":" + str2);
        System.out.println(":" + str2);

    }
}
