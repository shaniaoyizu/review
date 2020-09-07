package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 开启feign客户端
@EnableFeignClients
//@EnableCircuitBreaker //开启熔断器
//@SpringBootApplication
@SpringCloudApplication
public class ApplicationConsumerFeignFallbackMethod8880 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConsumerFeignFallbackMethod8880.class, args);
	}

}
