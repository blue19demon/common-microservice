package com.api.impl;

import java.util.UUID;

import com.api.person.PresonService;
import com.bean.APIResponse;
import com.bean.Preson;
import com.server.anno.RemoteService;

@RemoteService
public class PresonServiceImpl implements PresonService {

	@Override
	public String queryWeather(String city) {
		return city+" today is 35℃";
	}

	@Override
	public APIResponse getPresonInfo(Preson preson) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(UUID.randomUUID().toString());
		apiResponse.setTimpstamp(String.valueOf(System.currentTimeMillis()));
		return apiResponse;
	}
	
}