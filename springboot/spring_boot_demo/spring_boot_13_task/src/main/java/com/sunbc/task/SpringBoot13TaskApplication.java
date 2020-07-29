package com.sunbc.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableAsync
@SpringBootApplication
public class SpringBoot13TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot13TaskApplication.class, args);
	}

}