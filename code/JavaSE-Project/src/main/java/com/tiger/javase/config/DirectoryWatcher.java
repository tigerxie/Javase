/*
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.  * The Copyright to the computer program(s) herein is the property of Ericsson AB, Sweden. 
 * The program(s) may be used and/or copied with the written permission from Ericsson AB 
 * or in accordance with the terms and conditions stipulated in the agreement/contract 
 * under which the program(s) have been supplied. 
 */
package com.tiger.javase.config;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Observable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import static java.nio.file.StandardWatchEventKinds.*;

public class DirectoryWatcher extends Observable {

	private WatchService watcher;
	private Path path;
	private WatchKey key;
	private Executor executor = Executors.newSingleThreadExecutor();

	FutureTask<Integer> task = new FutureTask<Integer>(new Callable<Integer>() {
		public Integer call() throws InterruptedException {
			processEvents();
			return Integer.valueOf(0);
		}
	});

	@SuppressWarnings("unchecked")
	static <T> WatchEvent<T> cast(WatchEvent<?> event) {
		return (WatchEvent<T>) event;
	}

	public DirectoryWatcher(String dir) throws IOException {
		watcher = FileSystems.getDefault().newWatchService();
		path = Paths.get(dir);
		key = path.register(watcher, ENTRY_MODIFY, ENTRY_CREATE, ENTRY_DELETE);
	}

	public void execute() {
		executor.execute(task);
	}

	public void shutdown() throws IOException {
		watcher.close();
		executor = null;
	}

	void processEvents() {
		while (true) {
			WatchKey signal;
			try {
				signal = watcher.take();
			} catch (InterruptedException x) {
				return;
			}

			for (WatchEvent<?> event : signal.pollEvents()) {
				Kind<?> kind = event.kind();

				// TBD - provide example of how OVERFLOW event is handled
				if (kind == OVERFLOW) {
					continue;
				}

				// Context for directory entry event is the file name of entry
				WatchEvent<Path> ev = cast(event);
				Path name = ev.context();
				notifiy(name.getFileName().toString(), kind);
			}
			key.reset();
		}
	}

	void notifiy(String fileName, Kind<?> kind) {

		setChanged();

		notifyObservers(new FileSystemEventArgs(fileName, kind));
	}
}