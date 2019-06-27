package com.microservice.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.microservice.framework.Configure;
import com.microservice.framework.Protocol;
import com.microservice.framework.ProtocolFactory;
import com.microservice.framework.ProviderProtocol;
import com.microservice.framework.RPCConfigure;
import com.microservice.framework.URL;
import com.microservice.register.RegistryContiner;

import lombok.extern.slf4j.Slf4j;

@Component
@Order(value = 3)
@Slf4j
public class ServerStarterRunner implements CommandLineRunner {
	@Override
	public void run(String... var1) throws Exception {
		// 注册服务
		Configure conf = RPCConfigure.getConfigure();
		log.info("server use protocol = "+conf.getProtocol());
		URL url = new URL(conf.getHostname(), conf.getPort());
		if(ProviderProtocol.RESTFUL.equals(conf.getProtocol())) {
			RegistryContiner.restfulResourceScanner(conf.getRestfulScannerPackage());
		}
		// 启动
		Protocol client = ProtocolFactory.getProtocol(conf.getProtocol());
		client.start(url);
	}
}