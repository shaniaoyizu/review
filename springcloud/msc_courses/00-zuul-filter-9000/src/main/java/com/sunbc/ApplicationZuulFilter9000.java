package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ApplicationZuulFilter9000 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationZuulFilter9000.class, args);
	}

}
