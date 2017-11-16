/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.ericsson.upg.user360.mbean;

public class Car implements CarBean{
	private String color = "red";

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void drive() {
		System.out.println("Baby you can drive my car.");
	}
}