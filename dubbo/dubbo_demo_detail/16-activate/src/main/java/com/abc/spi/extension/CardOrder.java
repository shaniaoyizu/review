package com.abc.spi.extension;

import com.abc.spi.Order;
import org.apache.dubbo.common.extension.Activate;

@Activate(group = {"online", "offline"}, order = 3)
public class CardOrder implements Order {
    @Override
    public String way() {
        System.out.println("--- 银行卡way() ---");
        return "银行卡支付方式";
    }
}
