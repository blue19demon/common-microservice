package com.api.impl;

import com.api.user.UserDemoService;
import com.server.anno.RemoteService;
@RemoteService
public class UserDemoServiceImpl implements UserDemoService {

	@Override
	public String sayHello(String foo) {
		return "hello "+foo;
	}

}
