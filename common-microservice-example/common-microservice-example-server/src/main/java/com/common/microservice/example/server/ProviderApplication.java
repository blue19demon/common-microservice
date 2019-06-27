package com.common.microservice.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;

import com.microservice.annotation.EnableRPCAutoRegister;
import com.microservice.annotation.EnableRPCCxfRegister;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { PersistenceExceptionTranslationAutoConfiguration.class}) // 禁止springboot自动加载持久化bean
//@EnableRPCAutoRegister
@EnableRPCCxfRegister
public class ProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

}
