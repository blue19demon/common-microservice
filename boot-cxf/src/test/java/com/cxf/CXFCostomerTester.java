package com.cxf;

import java.util.ArrayList;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbgo.webservicedemo.DemoSeckillApplication;
import com.dbgo.webservicedemo.Model.User;
import com.dbgo.webservicedemo.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={DemoSeckillApplication.class})
public class CXFCostomerTester {
	@Test
	public void test() {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/service/user?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(UserService.class);

        UserService userService=(UserService)jaxWsProxyFactoryBean.create();
        User userResult= userService.getUser("411001");
        System.out.println("UserName:"+userResult.getUsername());
        ArrayList<User> users=userService.getAlLUser();
	}
	
}
