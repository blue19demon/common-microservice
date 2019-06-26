package com.microservice.core;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.microservice.annotation.RemoteService;
import com.microservice.framework.Configure;
import com.microservice.framework.ProviderProtocol;
import com.microservice.framework.RPCConfigure;
import com.microservice.framework.URL;
import com.microservice.register.ZKRegister;

public class ServiceAnnotationBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter
		implements PriorityOrdered {

	private int order = Ordered.LOWEST_PRECEDENCE - 1;
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		RemoteService remoteService = AnnotationUtils.findAnnotation(bean.getClass(), RemoteService.class);
		final Configure conf = RPCConfigure.getConfigure();
		Object resultBean = bean;
		if (null != remoteService) {
			Class<?> service = bean.getClass();
			String serviceName = service.getInterfaces()[0].getSimpleName();
			if (serviceName.startsWith("/")) {
				serviceName = serviceName.substring(1);
			}
			//RMI不走JDK的方式
			if (ProviderProtocol.RMI.equals(conf.getProtocol())) {
				resultBean = bySpringRMI(bean, conf, service, serviceName);
			}else {
				URL url=new URL(conf.getHostname(), conf.getPort());
				ZKRegister.register(service.getInterfaces()[0], url, service);
			}
		}
		return resultBean;
	}
	
	public RmiServiceExporter bySpringRMI(Object bean, final Configure conf, Class<?> service, String serviceName) {
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();
		rmiServiceExporter.setServiceInterface(service.getInterfaces()[0]);
		rmiServiceExporter.setService(bean);
		Integer rmiPort = conf.getPort();
		if (rmiPort == null) {
			rmiPort = Registry.REGISTRY_PORT;
		}
		rmiServiceExporter.setRegistryPort(rmiPort);
		if (serviceName.startsWith("/")) {
			serviceName = serviceName.substring(1);
		}
		System.out.println("serviceName=" + serviceName + ",rmiPort=" + rmiPort);
		rmiServiceExporter.setServiceName(serviceName);
		try {
			rmiServiceExporter.afterPropertiesSet();
		} catch (RemoteException remoteException) {
			throw new FatalBeanException("Exception initializing RmiServiceExporter", remoteException);
		}
		return rmiServiceExporter;
	}

	@Override
	public int getOrder() {
		return order;
	}
}