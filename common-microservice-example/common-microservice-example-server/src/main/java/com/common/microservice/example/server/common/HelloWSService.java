package com.common.microservice.example.server.common;

import com.common.microservice.example.common.api.HelloRemoteService;
import com.microservice.annotation.RemoteService;

@RemoteService
public class HelloWSService implements HelloRemoteService {
	
	public String say(String name) {
		return "hello "+name;
	}

}
