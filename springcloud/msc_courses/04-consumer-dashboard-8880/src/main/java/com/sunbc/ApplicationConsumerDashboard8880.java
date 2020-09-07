package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

// 开启feign客户端
@EnableFeignClients
@EnableHystrixDashboard //开启dashboard功能
@SpringCloudApplication
public class ApplicationConsumerDashboard8880 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationConsumerDashboard8880.class, args);
	}

}
