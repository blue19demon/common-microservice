package com.common.microservice.example.rmi.api;

import com.common.microservice.example.vo.UserVO;

public interface UserRemoteService {
	public UserVO save(UserVO user);
}
