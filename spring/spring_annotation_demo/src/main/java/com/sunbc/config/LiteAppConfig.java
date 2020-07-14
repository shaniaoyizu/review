package com.sunbc.config;

import com.sunbc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created on 2020-07-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
//@Component
@Configuration
public class LiteAppConfig {

    @Bean
    public User user() {
        System.out.println("user() 方法执行");
        return new User();
    }

    @Bean
    public String name(User user) {
        System.out.println("name(User user) 方法执行");
        System.out.println(user.hashCode());
        System.out.println("再次调用user()方法: " + user().hashCode());
        return "123";
    }
}
