package com.tiger.javase.concurrency.netty.dproxy.socks;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SocksProxy {
	 public void run() {

	        // Configure the bootstrap.
	        Executor executor = Executors.newCachedThreadPool();
	        Executor executorWorker = Executors.newCachedThreadPool();
	        ServerBootstrap sb = new ServerBootstrap(
	                new NioServerSocketChannelFactory(executor, executorWorker));

	        // Set up the event pipeline factory.
	        ClientSocketChannelFactory cf =
	                new NioClientSocketChannelFactory(executor, executorWorker);

	        sb.setPipelineFactory(
	                new SocksProxyPipelineFactory(cf));

	        // Start up the server.
	        sb.bind(new InetSocketAddress(1080));
	    }

	    public static void main(String[] args) {
	        new SocksProxy().run();
	    }
}
