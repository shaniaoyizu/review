package com.abc.spi.extension;

import com.abc.spi.Order;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = "offline", order = 4)
public class CashOrder implements Order {
    @Override
    public String way() {
        System.out.println("--- 现金way() ---");
        return "现金支付方式";
    }
}
