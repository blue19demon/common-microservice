package com.microservice.core;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

import com.microservice.framework.Configure;
import com.microservice.framework.ProviderProtocol;
import com.microservice.framework.RPCConfigure;
import com.microservice.framework.RemoteInterfaceGenarator;

/**
 * 自定义的代理工厂，用于将指定的接口转换为代理实体
 */
public class MyRmiProxyFactory<T> implements FactoryBean<T>, InitializingBean {

	private Class<T> interfaceClass;
	private String url = "localhost:1099";

	public MyRmiProxyFactory() {
	}

	public MyRmiProxyFactory(Class<T> interfaceClass) {
		this.interfaceClass = interfaceClass;
	}

	public MyRmiProxyFactory(String url, Class<T> interfaceClass) {
		this.interfaceClass = interfaceClass;
		this.url = url;
	}

	@SuppressWarnings("unchecked")
	public T createBean() {
		Configure conf = RPCConfigure.getConfigure();
		if (ProviderProtocol.RMI.equals(conf.getProtocol())) {
			RmiProxyFactoryBean bean = new RmiProxyFactoryBean();
			bean.setServiceUrl("rmi://" + url + "/" + interfaceClass.getSimpleName());
			bean.setServiceInterface(interfaceClass);
			bean.afterPropertiesSet();
			return (T) bean.getObject();
		}else {
			return RemoteInterfaceGenarator.genarate(interfaceClass);
		}
	}

	@Override
	public T getObject() throws Exception {
		return createBean();
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