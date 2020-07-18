package com.sunbc.provider;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableDubbo
//@ImportResource(locations = "classpath:provider.xml")
@DubboComponentScan("com.sunbc.provider")
@SpringBootApplication
public class BootDubboUserServiceProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDubboUserServiceProviderApplication.class, args);
	}

}
