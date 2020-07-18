package com.sunbc.provider.service.impl;

import com.sunbc.bean.UserAddress;
import com.sunbc.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@DubboService
@Component
public class UserServiceImpl implements UserService {

	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("userId: " + userId);
		System.out.println("UserServiceImpl...3...");
		// TODO Auto-generated method stub
		UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");
		if ("5".equals(userId)){
			throw new RuntimeException();
		}
		return Arrays.asList(address1,address2);
	}

}
