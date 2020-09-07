package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringCloudApplication
public class ApplicationZuulTokenBucket9000 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationZuulTokenBucket9000.class, args);
	}

}
