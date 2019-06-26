package com.common.microservice.example.cxf.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Preson implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName;

	private int age;
	
	private List<HelloEntity> helloEntityList;
	
	private Map<String,HelloEntity> helloEntityMap;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<HelloEntity> getHelloEntityList() {
		return helloEntityList;
	}

	public void setHelloEntityList(List<HelloEntity> helloEntityList) {
		this.helloEntityList = helloEntityList;
	}

	public Map<String, HelloEntity> getHelloEntityMap() {
		return helloEntityMap;
	}

	public void setHelloEntityMap(Map<String, HelloEntity> helloEntityMap) {
		this.helloEntityMap = helloEntityMap;
	}

	@Override
	public String toString() {
		return "Preson [userName=" + userName + ", age=" + age + ", helloEntityList=" + helloEntityList
				+ ", helloEntityMap=" + helloEntityMap + "]";
	}

	public Preson(String userName, int age, List<HelloEntity> helloEntityList,
			Map<String, HelloEntity> helloEntityMap) {
		super();
		this.userName = userName;
		this.age = age;
		this.helloEntityList = helloEntityList;
		this.helloEntityMap = helloEntityMap;
	}

	public Preson() {
		super();
	}
	
}
