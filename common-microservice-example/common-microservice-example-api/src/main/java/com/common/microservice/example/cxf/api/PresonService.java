package com.common.microservice.example.cxf.api;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.common.microservice.example.cxf.vo.APIResponse;
import com.common.microservice.example.cxf.vo.Preson;

@WebService
public interface PresonService {
	public String queryWeather(@WebParam(name = "city") String city);

	public APIResponse getPresonInfo(Preson preson);
}
