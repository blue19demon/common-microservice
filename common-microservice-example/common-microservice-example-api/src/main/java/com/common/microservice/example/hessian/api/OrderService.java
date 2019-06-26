package com.common.microservice.example.hessian.api;

import com.common.microservice.example.hessian.vo.Order;

public interface OrderService {
	
	public String helloWorld(String message);

    public Order getMyInfo(Order order);
}
