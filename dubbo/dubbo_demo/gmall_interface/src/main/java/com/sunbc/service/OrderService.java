package com.sunbc.service;

import com.sunbc.bean.UserAddress;

import java.util.List;

/**
 * Created on 2020-07-16
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface OrderService {
    List<UserAddress> initOrder(String usrId);
}
