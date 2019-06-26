package com.common.microservice.example.rest.api;

import java.math.BigDecimal;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.common.microservice.example.rest.vo.RestOrder;
import com.microservice.annotation.RestfulService;

@RestfulService
@Path("/orderAPI")
public interface RestOrderService {

	@GET
	@Path("/listGet")
	public List<RestOrder> list(@QueryParam("price") BigDecimal price);

}
