package com.sunbc.service.impl;

import com.sunbc.bean.UserAddress;
import com.sunbc.service.OrderService;
import com.sunbc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    UserService userService;

    public List<UserAddress> initOrder(String usrId) {
        List<UserAddress> userAddressList = userService.getUserAddressList(usrId);
        for (UserAddress address : userAddressList){
            System.out.println(address.getUserAddress());
        }
        return userAddressList;
    }
}
