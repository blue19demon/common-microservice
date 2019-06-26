package com.microservice.register;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import org.I0Itec.zkclient.ZkClient;
import org.redisson.api.RRemoteService;
import org.redisson.api.RedissonClient;

import com.caucho.hessian.server.HessianServlet;
import com.microservice.framework.Configure;
import com.microservice.framework.ProviderProtocol;
import com.microservice.framework.RPCConfigure;
import com.microservice.framework.URL;
import com.microservice.protocol.redis.RedissonClientBuilder;

@SuppressWarnings({"rawtypes","unchecked"})
public class RegistryContiner {

	private static Map<String, Map<URL, Class>> REGISTER = new HashMap<>();
	
	private static ZkClient zk = null;
	
	private static Map<String,Object> servletHolderMap=new HashMap<>();
	
	public static String resourceScannerPackage=null;
	
	static {
		Configure conf = RPCConfigure.getConfigure();
		String connection = conf.getZookeeperHostname() + ":" + conf.getZookeeperPort();
		zk = new ZkClient(connection);
	}

	public static void register(Class interfaceClazz, URL url, Class implClass,Object implObject) {
		String interfaceName=interfaceClazz.getName();
		Configure conf = RPCConfigure.getConfigure();
		if (ProviderProtocol.REDIS.equals(conf.getProtocol())) {
			try {
				RedissonClient redisson = RedissonClientBuilder.build();
				RRemoteService remoteService = redisson.getRemoteService();
				remoteService.register(interfaceClazz, implClass.newInstance());
				Map<URL, Class> map = new HashMap<>();
				map.put(url, implClass);
				REGISTER.put(interfaceClazz.getName(), map);
				writeToZK(REGISTER);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (ProviderProtocol.WEBSERVICE.equals(conf.getProtocol())) {
			if(interfaceClazz.isAnnotationPresent(WebService.class)) {
				String address="http://"+url.getHostName()+":"+url.getPort()+"/"+interfaceName;
				System.out.println(address);
				Endpoint.publish(address,implObject);
			}
		}else if (ProviderProtocol.HESSIAN.equals(conf.getProtocol())) {
			if(implObject instanceof HessianServlet) {
				servletHolderMap.put("/"+interfaceName, implObject);
			}
		}else if (false) {//ProviderProtocol.RMI.equals(conf.getProtocol())
			try {
				System.out.println("rmi://"+url.getHostName()+":"+url.getPort()+"/"+interfaceName);
				LocateRegistry.createRegistry(url.getPort());
				java.rmi.Naming.rebind("rmi://"+url.getHostName()+":"+url.getPort()+"/"+interfaceName, (Remote) implObject);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		Map<URL, Class> map = new HashMap<>();
		map.put(url, implClass);
		REGISTER.put(interfaceName, map);
		writeToZK(REGISTER);
	}
	

	private static void writeToZK(Map<String, Map<URL, Class>> register) {
		if (zk.exists("/zkConfig")) {
			zk.delete("/zkConfig");
		}
		zk.createPersistent("/zkConfig", true);
		zk.writeData("/zkConfig", register);
	}

	public static Class get(String interfaceName, URL url) {
		REGISTER = readFromZK();
		return REGISTER.get(interfaceName).get(url);
	}

	private static Map<String, Map<URL, Class>> readFromZK() {
		return zk.readData("/zkConfig");
	}

	public static Map<String, Object> getServletHolderMap() {
		return servletHolderMap;
	}

	/**
	 *   轮询算法
	 * @param interfaceName
	 * @return
	 */
	public static URL random(String interfaceName) {
		//TODO
		System.out.println(REGISTER.get(interfaceName));
		URL url = REGISTER.get(interfaceName).keySet().iterator().next();
		if (url == null) {
			url = new URL("localhost", 7777);
		}
		return url;
	}


	public static void restfulResourceScanner(String resourceScanner) {
		resourceScannerPackage=resourceScanner;
	}
}
