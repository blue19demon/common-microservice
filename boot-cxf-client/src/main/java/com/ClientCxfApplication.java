package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.client.anno.EnableAutoRemoteLookup;

@SpringBootApplication
@EnableAutoRemoteLookup
public class ClientCxfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCxfApplication.class, args);
	}
}
