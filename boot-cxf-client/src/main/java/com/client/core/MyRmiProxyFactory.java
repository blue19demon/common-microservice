package com.client.core;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import com.utils.APIProxy;

/**
 * 自定义的代理工厂，用于将指定的接口转换为代理实体
 */
public class MyRmiProxyFactory<T> implements FactoryBean<T>, InitializingBean {

	private Class<T> interfaceClass;
	private String url;

	public MyRmiProxyFactory() {
	}

	public MyRmiProxyFactory(Class<T> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public MyRmiProxyFactory(String url, Class<T> interfaceClass) {
		this.interfaceClass = interfaceClass;
		this.url = url;
	}

	@Override
	public T getObject() throws Exception {
		return APIProxy.genarate(url, interfaceClass);
	}

	@Override
	public Class<?> getObjectType() {
		return interfaceClass;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
	}
}