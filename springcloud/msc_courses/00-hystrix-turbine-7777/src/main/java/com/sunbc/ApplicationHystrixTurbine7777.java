package com.sunbc;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrixDashboard
@SpringCloudApplication
public class ApplicationHystrixTurbine7777 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationHystrixTurbine7777.class, args);
	}

}
