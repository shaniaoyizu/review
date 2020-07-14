package com.sunbc.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class SpringBoot11AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot11AmqpApplication.class, args);
	}

}
