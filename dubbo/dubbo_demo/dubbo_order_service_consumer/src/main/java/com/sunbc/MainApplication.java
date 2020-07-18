package com.sunbc;

import com.sunbc.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created on 2020-07-16
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = ioc.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("调用完成");
//        System.in.read();
    }
}
