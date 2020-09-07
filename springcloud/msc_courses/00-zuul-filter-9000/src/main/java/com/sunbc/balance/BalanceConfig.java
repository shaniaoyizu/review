package com.sunbc.balance;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created on 2020-09-06
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Configuration
public class BalanceConfig {

    @Bean
    public IRule loadBalanceRule(){
        return new RandomRule();
    }
}
