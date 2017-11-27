package com.tiger.concurrent.thread;

import java.util.concurrent.TimeUnit;

public class SleepUtils {

	@SuppressWarnings("static-access")
	public static void second(long l) {
		try {
			TimeUnit.SECONDS.sleep(l);
			// Thread.currentThread().sleep(l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
