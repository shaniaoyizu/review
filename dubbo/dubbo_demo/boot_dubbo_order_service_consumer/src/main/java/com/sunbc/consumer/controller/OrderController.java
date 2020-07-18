package com.sunbc.consumer.controller;

import com.sunbc.bean.UserAddress;
import com.sunbc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2020-07-16
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/initOrder/{uid}")
    public List<UserAddress> initOrder(@PathVariable("uid") String userId){
        List<UserAddress> addressList = orderService.initOrder(userId);
        return addressList;
    }
}
