package com.abc;

import com.abc.spi.Order;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.Set;

public class OrderTest {

    @Test
    public void test01() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);

        Order adaptiveExtension = loader.getAdaptiveExtension();
        URL url = URL.valueOf("xxx://localhost/ooo");
        System.out.println(adaptiveExtension.pay(url));
    }

    @Test
    public void test02() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        // 获取Order接口的所有扩展类的扩展名
        Set<String> extensions = loader.getSupportedExtensions();
        System.out.println(extensions);
    }
}
