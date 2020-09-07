package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ApplicationZuul9000 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationZuul9000.class, args);
	}

}
