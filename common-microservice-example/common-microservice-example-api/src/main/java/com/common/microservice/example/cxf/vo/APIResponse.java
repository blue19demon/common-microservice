package com.common.microservice.example.cxf.vo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class APIResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String timpstamp;
	private String data;
	public String getTimpstamp() {
		return timpstamp;
	}
	public void setTimpstamp(String timpstamp) {
		this.timpstamp = timpstamp;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "APIResponse [timpstamp=" + timpstamp + ", data=" + data + "]";
	}
	public APIResponse(String timpstamp, String data) {
		super();
		this.timpstamp = timpstamp;
		this.data = data;
	}
	public APIResponse() {
		super();
	}
	
}
