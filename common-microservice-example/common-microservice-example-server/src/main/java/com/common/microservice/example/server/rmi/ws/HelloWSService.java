package com.common.microservice.example.server.rmi.ws;

import com.common.microservice.example.rmi.api.HelloRemoteService;
import com.microservice.annotation.RemoteService;

@RemoteService
public class HelloWSService implements HelloRemoteService {
	
	public String say(String name) {
		return "hello "+name;
	}

}
