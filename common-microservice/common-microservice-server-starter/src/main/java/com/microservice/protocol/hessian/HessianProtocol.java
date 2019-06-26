package com.microservice.protocol.hessian;

import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class HessianProtocol implements Protocol {

	@Override
	public void start(URL url) {
		// 启动
		HessianServer server = new HessianServer();
		server.start(url.getHostName(), url.getPort());
	}

	@Override
	public Object post(URL urlParam, Invocation invocation) {
		return null;
	}
}
