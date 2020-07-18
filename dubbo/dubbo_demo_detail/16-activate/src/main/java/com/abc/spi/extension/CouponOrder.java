package com.abc.spi.extension;

import com.abc.spi.Order;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = "offline", order = 5)
public class CouponOrder implements Order {
    @Override
    public String way() {
        System.out.println("--- 购物券way() ---");
        return "购物券支付方式";
    }
}
