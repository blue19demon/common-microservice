package com.utils;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class APIProxy{

	@SuppressWarnings("unchecked")
	public static<T> T genarate(final String apiUrl,final Class<? extends T> interfaceClass) {
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean=new JaxWsProxyFactoryBean();
        jaxWsProxyFactoryBean.setAddress(apiUrl+interfaceClass.getName()+"?wsdl");
        jaxWsProxyFactoryBean.setServiceClass(interfaceClass);
		return (T) jaxWsProxyFactoryBean.create();
	}
}
