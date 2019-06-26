package com.common.microservice.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;

import com.microservice.annotation.EnableAutoRemoteLookup;



@SpringBootApplication
@EnableAutoConfiguration(exclude = { PersistenceExceptionTranslationAutoConfiguration.class})// 禁止springboot自动加载持久化bean
@EnableAutoRemoteLookup
public class CostomerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(CostomerApplication.class, args);
	} 
}
