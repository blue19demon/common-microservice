package com.common.microservice.example.server.rmi.ws;

import com.common.microservice.example.rmi.api.UserRemoteService;
import com.common.microservice.example.vo.UserVO;
import com.microservice.annotation.RemoteService;

@RemoteService
public class UserWSService implements UserRemoteService {

	public UserVO save(UserVO user) {
		System.out.println("param is " + user);
		user.setUserId(1);
		return user;
	}
	
}
