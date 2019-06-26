package com.microservice.framework;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Invocation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5917425187821512650L;

	private String interfaceName;
	
	private String methodName;
	
	private Object[] params;
	
	private Class<?>[] paramTypes;
}
