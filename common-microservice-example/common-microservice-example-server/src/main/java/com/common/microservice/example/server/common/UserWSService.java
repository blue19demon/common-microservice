package com.common.microservice.example.server.common;

import com.common.microservice.example.common.api.UserRemoteService;
import com.common.microservice.example.common.vo.UserVO;
import com.microservice.annotation.RemoteService;

@RemoteService
public class UserWSService implements UserRemoteService {

	public UserVO save(UserVO user) {
		System.out.println("param is " + user);
		user.setUserId(1);
		return user;
	}
	
}
