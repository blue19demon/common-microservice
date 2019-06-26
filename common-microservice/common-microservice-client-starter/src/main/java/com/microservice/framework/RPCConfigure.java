package com.microservice.framework;

import com.microservice.utils.PropertiesUtils;

public class RPCConfigure {
	
	private static Configure configure;

	static {
		configure = 
				Configure
				.builder()
				.providerAddress(String.valueOf(PropertiesUtils
						.getCommonYml("microservice.provider.address")))
				.protocol(String.valueOf(PropertiesUtils
						.getCommonYml("microservice.protocol.channel")))
				.zookeeperHostname(String.valueOf(PropertiesUtils
						.getCommonYml("microservice.registry.zookeeper.host.address")))
				.zookeeperPort((Integer) PropertiesUtils
						.getCommonYml("microservice.registry.zookeeper.host.port"))
				.redisHostname(String.valueOf(PropertiesUtils
						.getCommonYml("microservice.protocol.redis.address")))
				.redisPort((Integer) PropertiesUtils
						.getCommonYml("microservice.protocol.redis.port"))
				.mqHostname(String.valueOf(PropertiesUtils
						.getCommonYml("microservice.protocol.rabbit.address")))
				.mqPort((Integer) PropertiesUtils
						.getCommonYml("microservice.protocol.rabbit.port"))
				.mqUsername(String.valueOf(PropertiesUtils
						.getCommonYml("microservice.protocol.rabbit.username")))
				.mqPassword(String.valueOf(PropertiesUtils
						.getCommonYml("microservice.protocol.rabbit.password")))
				.remoteClientScanBasePackages(PropertiesUtils
						.getArrayYml("microservice.remoteClientScan.basePackages"))
				.build();
	}
	public static Configure getConfigure() {
		return configure;
	}

}
