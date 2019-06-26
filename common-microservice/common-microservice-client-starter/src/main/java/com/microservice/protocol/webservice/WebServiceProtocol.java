package com.microservice.protocol.webservice;

import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class WebServiceProtocol implements Protocol{
	
	@Override
	public void start(URL url) {
		WebServiceServer server = new WebServiceServer();
		server.start(url.getHostName(), url.getPort());
	}

	@Override
	public Object post(URL url, Invocation invocation) {
		return null;
	}
}
