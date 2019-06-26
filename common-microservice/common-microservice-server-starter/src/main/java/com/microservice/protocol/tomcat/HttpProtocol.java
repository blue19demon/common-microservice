package com.microservice.protocol.tomcat;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;

import com.microservice.framework.Invocation;
import com.microservice.framework.Protocol;
import com.microservice.framework.URL;

public class HttpProtocol implements Protocol {

	@Override
	public void start(URL url) {
		// 启动
		HttpServer server = new HttpServer();
		server.start(url.getHostName(), url.getPort());
	}

	@Override
	public Object post(URL urlParam, Invocation invocation) {
		try {
			java.net.URL url = new java.net.URL("http", urlParam.getHostName(), urlParam.getPort(), "/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(outputStream);
			oos.writeObject(invocation);
			oos.flush();
			oos.close();
			InputStream inputStream = connection.getInputStream();
			if(inputStream!=null) {
				ObjectInputStream ois=new ObjectInputStream(inputStream);
				return ois.readObject();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
