package com.common.microservice.example.common.api;

import com.common.microservice.example.common.vo.UserVO;

public interface UserRemoteService {
	public UserVO save(UserVO user);
}
