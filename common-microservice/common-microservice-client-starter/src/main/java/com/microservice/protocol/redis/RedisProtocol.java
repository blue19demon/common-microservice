package com.microservice.protocol.redis;

import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class RedisProtocol implements Protocol {

	@Override
	public void start(URL url) {
		System.out.println("redis server started");
	}

	@Override
	public Object post(URL urlParam, Invocation invocation) {
		return null;
	}
}
