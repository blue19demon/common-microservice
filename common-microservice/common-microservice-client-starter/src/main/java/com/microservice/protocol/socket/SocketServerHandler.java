package com.microservice.protocol.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;

import com.microservice.framework.Configure;
import com.microservice.framework.Invocation;
import com.microservice.framework.RPCConfigure;
import com.microservice.framework.URL;
import com.microservice.register.ZKRegister;
public class SocketServerHandler implements Runnable{
	
	private Socket socket;
	
	public SocketServerHandler(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(socket.getInputStream());
			Invocation invocation = (Invocation)ois.readObject();
			Object result = handleRpc(invocation);
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			oos.writeObject(result);
			oos.flush();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Object handleRpc(Invocation invocation) {
		try {
			Configure conf=RPCConfigure.getConfigure();
			URL url=new URL(conf.getHostname(), conf.getPort());
			Class<?> inplClass=ZKRegister.get(invocation.getInterfaceName(), url);
			Method method=inplClass.getDeclaredMethod(invocation.getMethodName(), invocation.getParamTypes());
			Object result = method.invoke(inplClass.newInstance(), invocation.getParams());
			return result;
		} catch (InvocationTargetException e) {
			e.getTargetException().printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
