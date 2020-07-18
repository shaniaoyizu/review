package com.abc.spi.extension;

import com.abc.spi.Order;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = "online", value = "alipay")
public class AlipayOrder implements Order {
    @Override
    public String way() {
        System.out.println("--- 支付宝way() ---");
        return "支付宝支付方式";
    }
}
