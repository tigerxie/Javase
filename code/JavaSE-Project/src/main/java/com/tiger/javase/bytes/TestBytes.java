/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.ericsson.upg.bytes;

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
