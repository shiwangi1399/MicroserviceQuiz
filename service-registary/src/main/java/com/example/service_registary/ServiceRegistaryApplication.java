package com.example.service_registary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRegistaryApplication.class, args);
	}

}
