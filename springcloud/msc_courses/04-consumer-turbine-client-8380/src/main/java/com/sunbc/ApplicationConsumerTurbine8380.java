package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 开启feign客户端
@EnableFeignClients
@SpringCloudApplication
public class ApplicationConsumerTurbine8380 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConsumerTurbine8380.class, args);
	}

}
