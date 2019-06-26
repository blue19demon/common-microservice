package com.microservice.register;

import java.util.HashMap;
import java.util.Map;

import org.I0Itec.zkclient.ZkClient;

import com.microservice.framework.Configure;
import com.microservice.framework.RPCConfigure;
import com.microservice.framework.URL;

@SuppressWarnings({"rawtypes"})
public class RegistryContiner {

	private static Map<String, Map<URL, Class>> REGISTER = new HashMap<>();
	
	private static ZkClient zk = null;
	
	public static Map<String,Object> servletHolderMap = new HashMap<>();
	
	public static String resourceScannerPackage = null;
	
	static {
		Configure conf = RPCConfigure.getConfigure();
		String connection = conf.getZookeeperHostname() + ":" + conf.getZookeeperPort();
		zk = new ZkClient(connection);
	}

	public static void register(Class interfaceClazz, URL url, Class implClass,Object implObject) {
		String interfaceName=interfaceClazz.getName();
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
