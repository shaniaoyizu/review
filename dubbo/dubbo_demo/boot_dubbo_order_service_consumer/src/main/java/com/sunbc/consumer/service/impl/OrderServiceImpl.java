package com.sunbc.consumer.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunbc.bean.UserAddress;
import com.sunbc.service.OrderService;
import com.sunbc.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2020-07-16
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Service
public class OrderServiceImpl implements OrderService {

    @DubboReference(loadbalance = "roundrobin")
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder(String usrId) {
        List<UserAddress> userAddressList = userService.getUserAddressList(usrId);
        for (UserAddress address : userAddressList){
            System.out.println(address.getUserAddress());
        }
        return userAddressList;
    }

    public List<UserAddress> hello(String usrId) {
        return Arrays.asList(new UserAddress(10,"测试地址","1","测试","测试","Y"));
    }
}
