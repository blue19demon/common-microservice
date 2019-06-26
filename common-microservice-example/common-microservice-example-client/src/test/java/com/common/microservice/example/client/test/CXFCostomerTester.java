package com.common.microservice.example.client.test;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.common.microservice.example.client.CostomerApplication;
import com.common.microservice.example.cxf.api.PresonService;
import com.common.microservice.example.cxf.api.UserDemoService;
import com.common.microservice.example.cxf.vo.HelloEntity;
import com.common.microservice.example.cxf.vo.Preson;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={CostomerApplication.class})
public class CXFCostomerTester {

	@Autowired
	private PresonService presonService;
	@Autowired
	private UserDemoService demoService;
	@Test
	public void test() {
		System.out.println(presonService.queryWeather("成都"));
		Preson p =new Preson();
		p.setAge(22);
		p.setUserName("张三丰");
		p.setHelloEntityList(Arrays.asList(new HelloEntity("hello"),new HelloEntity("word")));
		p.setHelloEntityMap(new HashMap<String, HelloEntity>(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 3818670253379150798L;

			{
				put("key1", new HelloEntity("hello"));
				put("key2", new HelloEntity("word"));
			}
		});
		System.out.println(presonService.getPresonInfo(p));
		System.out.println(demoService.sayHello("你们"));
	}
	
}
