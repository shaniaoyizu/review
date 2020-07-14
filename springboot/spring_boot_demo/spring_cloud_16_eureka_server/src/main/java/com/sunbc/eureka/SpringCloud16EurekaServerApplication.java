package com.sunbc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloud16EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloud16EurekaServerApplication.class, args);
	}

}
