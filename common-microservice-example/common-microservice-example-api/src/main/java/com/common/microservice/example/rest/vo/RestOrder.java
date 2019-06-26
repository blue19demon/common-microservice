package com.common.microservice.example.rest.vo;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@ToString
public class RestOrder {

	private String orderSerialNo;
	private BigDecimal price;
}
