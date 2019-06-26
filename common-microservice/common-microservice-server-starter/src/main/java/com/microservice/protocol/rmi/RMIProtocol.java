package com.microservice.protocol.rmi;

import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class RMIProtocol implements Protocol{
	
	@Override
	public void start(URL url) {
		RMIServer server = new RMIServer();
		server.start(url.getHostName(), url.getPort());
	}

	@Override
	public Object post(URL url, Invocation invocation) {
		return null;
	}
}
