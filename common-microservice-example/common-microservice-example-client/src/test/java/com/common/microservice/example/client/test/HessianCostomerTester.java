package com.common.microservice.example.client.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.microservice.example.client.CostomerApplication;
import com.common.microservice.example.hessian.api.HelloService;
import com.common.microservice.example.hessian.api.OrderService;
import com.common.microservice.example.hessian.vo.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={CostomerApplication.class})
public class HessianCostomerTester {

	@Autowired
	private OrderService OrderService;
	@Autowired
	private HelloService helloService;
	@Test
	public void test() {
		Order order = new Order();
		order.setUserName("zz");
		System.out.println(OrderService.helloWorld("hessian"));
		System.out.println(OrderService.getMyInfo(order));

		System.out.println(helloService.sayHello("RPC"));
		helloService.save();
	}
	
}
