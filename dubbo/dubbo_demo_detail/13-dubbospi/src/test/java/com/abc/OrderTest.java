package com.abc;

import com.abc.spi.Order;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

public class OrderTest {

    @Test
    public void test01() {
        // 获取SPI接口Order的扩展加载实例
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);

        // 获取指定名称的扩展类
        Order alipay = loader.getExtension("alipay");
        System.out.println(alipay.way());
        Order wechat = loader.getExtension("wechat");
        System.out.println(wechat.way());
        Order wechat2 = loader.getExtension("wechat2");
        System.out.println(wechat2.way());
    }

    @Test
    public void test02() {
        // 获取SPI接口Order的扩展加载实例
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);

        // 想获取默认的扩展类（会报错，SPI中指定的默认值不是这样使用的）
        Order wechat = loader.getExtension(null);
        System.out.println(wechat.way());
    }

}
