package com.abc.spi.extension;

import com.abc.spi.Order;
import org.apache.dubbo.common.URL;

public class OrderWrapper2 implements Order {

    private Order order;

    public OrderWrapper2(Order order) {
        this.order = order;
    }

    @Override
    public String way() {
        System.out.println("before222-这是wrapper对way()的增强");
        String way = order.way();
        System.out.println("after222-这是wrapper对way()的增强");
        return way;
    }

    @Override
    public String pay(URL url) {
        System.out.println("before222-这是wrapper对pay()的增强");
        String pay = order.pay(url);
        System.out.println("after222-这是wrapper对pay()的增强");
        return pay;
    }
}
