package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ApplicationEurekaServer8300 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationEurekaServer8300.class, args);
	}

}
