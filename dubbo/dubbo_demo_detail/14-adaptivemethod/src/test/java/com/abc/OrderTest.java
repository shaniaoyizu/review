package com.abc;

import com.abc.spi.Order;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class OrderTest {

    @Test
    public void test01() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);

        Order adaptiveExtension = loader.getAdaptiveExtension();
        // 模拟一个URL
        URL url = URL.valueOf("xxx://localhost/ooo");
        System.out.println(adaptiveExtension.pay(url));
    }

    @Test
    public void test02() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);

        Order adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("xxx://localhost/ooo?order=wechat");
        // XxxOoo  =>  xxx.ooo
        System.out.println(adaptiveExtension.pay(url));
    }
}
