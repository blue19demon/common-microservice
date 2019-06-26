package com.common.microservice.example.server.rest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import com.common.microservice.example.rest.api.RestOrderService;
import com.common.microservice.example.rest.vo.RestOrder;
import com.microservice.annotation.RemoteService;
import com.sun.jersey.spi.resource.Singleton;

@Path("/orderAPI")
@Singleton
@RemoteService
public class RestOrderServiceImpl implements RestOrderService {

	@Override
	@Path("/listGet")
	@GET
	public List<RestOrder> list(@QueryParam("price") BigDecimal price) {
		return Arrays.asList(
				new RestOrder(UUID.randomUUID().toString().replaceAll("-", ""), price.setScale(2, RoundingMode.DOWN)),
				new RestOrder(UUID.randomUUID().toString().replaceAll("-", ""), price.setScale(2, RoundingMode.DOWN)),
				new RestOrder(UUID.randomUUID().toString().replaceAll("-", ""), price.setScale(2, RoundingMode.DOWN)));
	}

}
