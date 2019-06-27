package com.api.person;

import javax.jws.WebService;

import com.bean.APIResponse;
import com.bean.Preson;

@WebService
public interface PresonService {

	public String queryWeather(String city);

	public APIResponse getPresonInfo(Preson preson);
}
