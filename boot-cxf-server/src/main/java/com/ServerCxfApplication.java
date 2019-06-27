package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.server.anno.EnableRPCCxfRegister;

@SpringBootApplication
@EnableRPCCxfRegister
public class ServerCxfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerCxfApplication.class, args);
	}
}
