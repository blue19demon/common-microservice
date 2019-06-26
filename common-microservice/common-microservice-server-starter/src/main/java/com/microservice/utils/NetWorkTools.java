package com.microservice.utils;

import java.net.InetAddress;

public class NetWorkTools {
	
	public static String getLocalIp() {
		try {
			InetAddress ia = InetAddress.getLocalHost();
			String localip = ia.getHostAddress();
			return localip;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
