package com.common.microservice.example.server.cxf;

import com.alibaba.fastjson.JSONObject;
import com.common.microservice.example.cxf.api.PresonService;
import com.common.microservice.example.cxf.vo.APIResponse;
import com.common.microservice.example.cxf.vo.Preson;
import com.microservice.annotation.RemoteService;

@RemoteService
public class PresonServiceImpl implements PresonService {

	@Override
	public String queryWeather(String city) {
		return city+" today is 35℃";
	}

	@Override
	public APIResponse getPresonInfo(Preson preson) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setData(JSONObject.toJSONString(preson));
		apiResponse.setTimpstamp(String.valueOf(System.currentTimeMillis()));
		return apiResponse;
	}
	
}