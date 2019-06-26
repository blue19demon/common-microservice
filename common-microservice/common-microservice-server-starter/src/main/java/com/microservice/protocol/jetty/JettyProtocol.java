package com.microservice.protocol.jetty;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;


import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class JettyProtocol implements Protocol {

	@Override
	public void start(URL url) {
		// 启动
		JettyServer server = new JettyServer();
		server.start(url.getHostName(), url.getPort());
		System.out.println("jetty started");
	}

	@Override
	public Object post(URL urlParam, Invocation invocation) {
		HttpURLConnection connection=null;
		try {
			java.net.URL url = new java.net.URL("http", urlParam.getHostName(), urlParam.getPort(), "/");
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			oos.writeObject(invocation);
			oos.flush();
			InputStream inputStream = connection.getInputStream();
			if(inputStream!=null) {
				ObjectInputStream ois=new ObjectInputStream(inputStream);
				return ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			connection.disconnect();
		}
		return null;
	}
}
