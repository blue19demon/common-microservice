package com.microservice.framework;

import com.microservice.protocol.hessian.HessianProtocol;
import com.microservice.protocol.jetty.JettyProtocol;
import com.microservice.protocol.mq.MQProtocol;
import com.microservice.protocol.netty.NettyProtocol;
import com.microservice.protocol.redis.RedisProtocol;
import com.microservice.protocol.restful.RestfulProtocol;
import com.microservice.protocol.rmi.RMIProtocol;
import com.microservice.protocol.socket.SocketProtocol;
import com.microservice.protocol.tomcat.HttpProtocol;
import com.microservice.protocol.webservice.WebServiceProtocol;

public class ProtocolFactory {

	public static Protocol getProtocol(String type) {
		Protocol protocol = null;
		switch (type) {
		case ProviderProtocol.NETTY:
			protocol=new NettyProtocol();
			break;
		case ProviderProtocol.JETTY:
			protocol = new JettyProtocol();
			break;
		case ProviderProtocol.HTTP:
			protocol = new HttpProtocol();
			break;
		case ProviderProtocol.SOCKET:
			protocol = new SocketProtocol();
			break;
		case ProviderProtocol.RMI:
			protocol = new RMIProtocol();
			break;
		case ProviderProtocol.HESSIAN:
			protocol = new HessianProtocol();
			break;
		case ProviderProtocol.WEBSERVICE:
			protocol = new WebServiceProtocol();
			break;
		case ProviderProtocol.RESTFUL:
			protocol = new RestfulProtocol();
			break;
		case ProviderProtocol.REDIS:
			protocol = new RedisProtocol();
			break;
		case ProviderProtocol.MQ:
			protocol = new MQProtocol();
			break;
		default:
			protocol = new HttpProtocol();
			break;
		}
		return protocol;
	}
}
