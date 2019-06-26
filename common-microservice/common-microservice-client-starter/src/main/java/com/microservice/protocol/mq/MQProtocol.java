package com.microservice.protocol.mq;

import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class MQProtocol implements Protocol {

	@Override
	public void start(URL url) {
		// 启动
		MQServer server = new MQServer();
		server.start(url.getHostName(), url.getPort());
	}

	@Override
	public Object post(URL urlParam, Invocation invocation) {
		return null;
	}
}
