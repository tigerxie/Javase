package com.ericsson.upg.concurrency.netty.dproxy;

public interface Proxy {
	
	public void start();

	public void stop();

	public void loadCache(String cacheFile);
}
