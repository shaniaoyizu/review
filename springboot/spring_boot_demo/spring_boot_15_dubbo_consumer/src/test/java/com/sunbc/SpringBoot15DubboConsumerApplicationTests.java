package com.sunbc;

import com.sunbc.consumer.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBoot15DubboConsumerApplicationTests {

	@Autowired
	UserService userService;

	@Test
	void contextLoads() {
		userService.hello();
	}

}
