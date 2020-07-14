package com.sunbc.config;

import com.sunbc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2020-07-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Configuration
public class AppConfig {

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public String name(User user) {
        System.out.println(user.hashCode());
        System.out.println(user().hashCode());
        return "123";
    }
}
