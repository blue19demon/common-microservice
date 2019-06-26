package com.dbgo.webservicedemo;

import java.util.ArrayList;
import java.util.Date;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.dbgo.webservicedemo.Model.User;
import com.dbgo.webservicedemo.service.UserService;

public class webserviceclient {

    //动态调用
    public static void main(String[] args) throws Exception {
        main3(args);
    }

    //调用方式三，通过接口协议获取数据类型,设置链接超时和响应时间
    public static void main3(String[] args) throws Exception {
        JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress("http://localhost:8080/service/user?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(UserService.class);

        UserService userService = (UserService) jaxWsProxyFactoryBean.create(); // 创建客户端对象
        Client proxy= ClientProxy.getClient(userService);
        HTTPConduit conduit=(HTTPConduit)proxy.getConduit();
        HTTPClientPolicy policy=new HTTPClientPolicy();
        policy.setConnectionTimeout(1000);
        policy.setReceiveTimeout(1000);
        conduit.setClient(policy);

        User userResult= userService.getUser("411001");
        System.out.println("UserName:"+userResult.getUsername());
        ArrayList<User> users=userService.getAlLUser();
        for (User user : users) {
        	System.out.println(user);
		}

        
        User u=new User();
        u.setAge("12");
        u.setUserId("22");
        System.out.println(userService.saveUser(u, "张三"));
    }
}