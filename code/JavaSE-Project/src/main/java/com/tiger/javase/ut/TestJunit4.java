/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.ut;

public class TestJunit4 {
	private IMathfun util;

	public TestJunit4(IMathfun util) {
		this.util = util;
	}

	public int cal(int num) {
		return 10 * util.abs(num);
	}
}