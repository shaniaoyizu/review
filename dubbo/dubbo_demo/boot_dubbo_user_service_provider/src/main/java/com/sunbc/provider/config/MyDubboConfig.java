package com.sunbc.provider.config;

import com.sunbc.service.UserService;
import org.apache.dubbo.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * Created on 2020-07-16
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Configuration
public class MyDubboConfig {

    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig config = new ApplicationConfig();
        config.setName("boot_dubbo_user_service_provider");
        return config;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig config = new RegistryConfig();
        config.setProtocol("zookeeper");
        config.setAddress("192.168.2.14:2181");
        return config;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig config = new ProtocolConfig();
        config.setName("dubbo");
        config.setPort(20882);
        return config;
    }

    @Bean
    public ServiceConfig<UserService> userServiceConfig(UserService userService){
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface(UserService.class);
        serviceConfig.setRef(userService);
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(1000);
        serviceConfig.setMethods(Arrays.asList(methodConfig));
        return serviceConfig;
    }
}
