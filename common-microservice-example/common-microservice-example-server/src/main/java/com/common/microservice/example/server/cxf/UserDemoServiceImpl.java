package com.common.microservice.example.server.cxf;

import com.common.microservice.example.cxf.api.UserDemoService;
import com.microservice.annotation.RemoteService;
@RemoteService
public class UserDemoServiceImpl implements UserDemoService {

	@Override
	public String sayHello(String foo) {
		return "hello "+foo;
	}

}
