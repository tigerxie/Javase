/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.staticblock;

/**
 * Hello world!
 *
 */
public class TestStaticBlock {

    public static void main(String[] args) throws ClassNotFoundException {
        // don't print log.
        Class[] classArray = { Test.class };

        // don't print log.
        Class.forName("com.tiger.javase.Test", false, TestStaticBlock.class.getClassLoader());

        // print log once.
        Class.forName("com.tiger.javase.Test");

        // print log once.
        Class.forName("com.tiger.javase.Test", true, TestStaticBlock.class.getClassLoader());
    }
}

class Test {
    static {
        System.out.println("static block");
    }
}