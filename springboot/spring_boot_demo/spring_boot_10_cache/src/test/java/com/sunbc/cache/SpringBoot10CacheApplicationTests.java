package com.sunbc.cache;

import com.sunbc.cache.bean.Employee;
import com.sunbc.cache.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class SpringBoot10CacheApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	RedisTemplate<Object,Employee> employeeRedisTemplate;

	@Test
	void contextLoads() {
		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
	}

	@Test
	public void test01(){
//		stringRedisTemplate.opsForValue().append("msg","hello");
//		String msg = stringRedisTemplate.opsForValue().get("msg");
//		System.out.println(msg);

		stringRedisTemplate.opsForList().leftPush("mylist","1");
		stringRedisTemplate.opsForList().leftPush("mylist","2");
	}

	@Test
	public void test02(){
//		redisTemplate.opsForValue().set("emp-01",employeeMapper.getEmpById(1));
		employeeRedisTemplate.opsForValue().set("emp-01",employeeMapper.getEmpById(1));
	}

	@Test
	public void test03(){
		Employee employee = employeeRedisTemplate.opsForValue().get("emp-01");
		System.out.println(employee);
	}

}
