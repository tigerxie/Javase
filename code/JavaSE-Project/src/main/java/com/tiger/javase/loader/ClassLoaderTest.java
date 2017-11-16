/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.ericsson.upg.loader;

import java.io.File;
import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.tiger.javase.bytes.TestBytes;

public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException {

		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		final String BUILTIN_PACKAGE = ClassLoaderTest.class.getPackage().getName();

		final String BUILTIN_LOCATION = "classpath*:" + BUILTIN_PACKAGE.replace('.', File.separatorChar)
				+ File.separator + "**/*.class";

//		System.out.println(BUILTIN_PACKAGE);
//		System.out.println(BUILTIN_LOCATION);

		try {
			Resource[] resources = resourcePatternResolver.getResources(BUILTIN_LOCATION);
			ClassLoader cl = ClassLoaderTest.class.getClassLoader();
			for (Resource resource : resources) {
				String cn = BUILTIN_PACKAGE + "." + resource.getFilename().replace(".class", "");
				System.out.println(cn);
				Class<?> clazz = cl.loadClass(cn);
				System.out.println(clazz);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}