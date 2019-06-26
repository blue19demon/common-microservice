package com.common.microservice.example.client.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.microservice.example.client.CostomerApplication;
import com.common.microservice.example.common.api.HelloRemoteService;
import com.common.microservice.example.common.api.UserRemoteService;
import com.common.microservice.example.common.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={CostomerApplication.class})
public class CommonCostomerTester {

	@Autowired
	private HelloRemoteService helloRemoteService;
	@Autowired
	private UserRemoteService userRemoteService;
	@Test
	public void test() {
		System.out.println(helloRemoteService.say("张三年"));
		UserVO user=new UserVO().setUserName("張三丰").setPassword("111").setPhone("1828737448");
		System.out.println(userRemoteService.save(user));
	}
	
}
