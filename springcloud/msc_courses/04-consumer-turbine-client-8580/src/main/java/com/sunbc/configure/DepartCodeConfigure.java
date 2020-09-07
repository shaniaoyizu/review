package com.sunbc.configure;

import com.netflix.loadbalancer.IRule;
import com.sunbc.balance.CustomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Configuration
public class DepartCodeConfigure {

    //修改负载均衡策略为随机
//    @Bean
//    public IRule loadBalanceRule(){
//        return new RandomRule();
//    }

    @Bean
    public IRule loadBalanceRule(){
        List<Integer> excludePorts = new ArrayList<>();
        excludePorts.add(8883);
        return new CustomRule(excludePorts);
    }
}
