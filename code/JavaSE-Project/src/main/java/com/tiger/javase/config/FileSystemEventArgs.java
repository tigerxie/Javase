/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.config;

import java.nio.file.WatchEvent.Kind;

public final class FileSystemEventArgs {
	private final String fileName;
	private final Kind<?> kind;

	public FileSystemEventArgs(String fileName, Kind<?> kind) {
		this.fileName = fileName;
		this.kind = kind;
	}

	public String getFileName() {
		return fileName;
	}

	@SuppressWarnings("rawtypes")
	public Kind getKind() {
		return kind;
	}
}