package com.microservice.framework;

import com.microservice.utils.NetWorkTools;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Configure {

	private Integer port;
	
	private String protocol;

	private String zookeeperHostname;

	private Integer zookeeperPort;

	private String redisHostname;

	private Integer redisPort;

	private String mqHostname;

	private Integer mqPort;

	private String mqUsername;

	private String mqPassword;
	
	private String restfulScannerPackage;

	public String getProtocol() {
		String realProtocol = ProviderProtocol.HTTP;
		switch (this.protocol) {
		case "netty":
			realProtocol = ProviderProtocol.NETTY;
			break;
		case "jetty":
			realProtocol = ProviderProtocol.JETTY;
			break;
		case "socket":
			realProtocol = ProviderProtocol.SOCKET;
			break;
		case "rmi":
			realProtocol = ProviderProtocol.RMI;
			break;
		case "hessian":
			realProtocol = ProviderProtocol.HESSIAN;
			break;
		case "redis":
			realProtocol = ProviderProtocol.REDIS;
			break;
		case "webservice":
			realProtocol = ProviderProtocol.WEBSERVICE;
			break;
		case "restful":
			realProtocol = ProviderProtocol.RESTFUL;
			break;
		case "mq":
			realProtocol = ProviderProtocol.MQ;
			break;
		default:
			realProtocol = ProviderProtocol.HTTP;
			break;
		}
		return realProtocol;
	}

	public String getHostname() {
		return NetWorkTools.getLocalIp();
	}

}
