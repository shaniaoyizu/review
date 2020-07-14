package com.sunbc.amqp;

import com.sunbc.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringBoot11AmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	void contextLoads() {
		Map<String,Object> map = new HashMap<>();
		map.put("msg","这是第一个消息");
		map.put("data", Arrays.asList("helloworld",123,true));
//		rabbitTemplate.convertAndSend("exchange.direct","auguigu.news",map);
		rabbitTemplate.convertAndSend("exchange.direct","auguigu.news",new Book("西游记","吴承恩"));
	}

	@Test
	public void receive(){
		Object o = rabbitTemplate.receiveAndConvert("auguigu.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	@Test
	public void sendMsg(){
		rabbitTemplate.convertAndSend("exchange.fanout","",new Book("红楼梦","曹雪芹"));
	}

	@Test
	public void createExchange(){
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
	}

	@Test
	public void createQueue(){
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue"));
	}

	@Test
	public void createBinding(){
		amqpAdmin.declareBinding(new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.haha",null));
	}

}
