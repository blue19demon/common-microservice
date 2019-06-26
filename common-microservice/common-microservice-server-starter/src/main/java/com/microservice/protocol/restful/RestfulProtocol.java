package com.microservice.protocol.restful;

import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class RestfulProtocol implements Protocol {

	@Override
	public void start(URL url) {
		// 启动
		RestfulServer server = new RestfulServer();
		server.start(url.getHostName(), url.getPort());
	}

	@Override
	public Object post(URL urlParam, Invocation invocation) {
		return null;
	}
}
