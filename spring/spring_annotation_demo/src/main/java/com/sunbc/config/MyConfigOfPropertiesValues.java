package com.sunbc.config;

import com.sunbc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created on 2020-06-29
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Configuration
@PropertySource(value = {"classpath:/person.properties"})
public class MyConfigOfPropertiesValues {

    @Bean
    public Person person(){
        return new Person();
    }
}
