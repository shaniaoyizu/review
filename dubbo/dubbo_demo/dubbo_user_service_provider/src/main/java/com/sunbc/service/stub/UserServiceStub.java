package com.sunbc.service.stub;

import com.sunbc.bean.UserAddress;
import com.sunbc.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created on 2020-07-16
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class UserServiceStub implements UserService {

    private final UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("stub...");
        if (!StringUtils.isEmpty(userId)){
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
