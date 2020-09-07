package com.sunbc.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Configuration
public class DepartCodeConfigure {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
