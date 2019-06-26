package com.common.microservice.example.cxf.api;

import javax.jws.WebService;

import com.common.microservice.example.cxf.vo.APIResponse;
import com.common.microservice.example.cxf.vo.Preson;

@WebService
public interface PresonService {

	String queryWeather(String city);

	public APIResponse getPresonInfo(Preson preson);
}
