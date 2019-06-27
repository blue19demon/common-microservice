package com.cxf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ClientCxfApplication;
import com.api.person.PresonService;
import com.api.user.UserDemoService;
import com.api.user.UserService;
import com.bean.HelloEntity;
import com.bean.Preson;
import com.bean.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { ClientCxfApplication.class })
public class ClientCxfApplicationTests {
	
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserDemoService userDemoService;
	@Autowired
	private PresonService presonService;
	@Test
	public void contextLoads() {
		User userResult = userService.getUser("411001");
		System.out.println("UserName:" + userResult.getUsername());
		ArrayList<User> users = userService.getAlLUser();
		for (User user : users) {
			System.out.println(user);
		}
		User user = new User();
		user.setAge("28");
		user.setUserId("1");
		System.out.println(userService.saveUser(user));

		System.out.println(presonService.queryWeather("成都"));
		Preson p = new Preson();
		p.setAge(22);
		p.setUserName("张三丰");
		p.setHelloEntityList(Arrays.asList(new HelloEntity("hello"), new HelloEntity("word")));
		p.setHelloEntityMap(new HashMap<String, HelloEntity>() {
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

		System.out.println(userDemoService.sayHello("你们"));
	}

}
