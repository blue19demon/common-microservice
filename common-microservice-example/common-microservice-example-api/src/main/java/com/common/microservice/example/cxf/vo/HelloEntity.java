package com.common.microservice.example.cxf.vo;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class HelloEntity {

	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public HelloEntity(String word) {
		super();
		this.word = word;
	}

	@Override
	public String toString() {
		return "HelloEntity [word=" + word + "]";
	}

	public HelloEntity() {
		super();
	}
	
}
