package com.sunbc.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.sunbc.cache.mapper")
@SpringBootApplication
@EnableCaching
public class SpringBoot10CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot10CacheApplication.class, args);
	}

}
