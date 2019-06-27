package com.microservice.core;

import java.util.Map;

import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.microservice.annotation.RemoteService;

/**
 *  * spring boot 容器加载完成后执行  
 */

public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null) {
			// 只有root application context 没有父容器
			ApplicationContext ac = event.getApplicationContext();
			Map<String, Object> beans = ac.getBeansWithAnnotation(RemoteService.class);
			if (beans != null && beans.keySet().size() > 0) {
				EndpointImpl endpoint = null;
				for (Object bean : beans.values()) {
					System.err.println(bean == null ? "null" : bean.getClass().getName());
					if(bean == null) {
						continue;
					}
					endpoint = new EndpointImpl(bean);
					endpoint.publish("/" + bean.getClass().getInterfaces()[0].getName());// 绑定要发布的服务
				}
			}
		}
	}
}