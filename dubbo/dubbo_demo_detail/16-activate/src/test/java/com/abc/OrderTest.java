package com.abc;

import com.abc.spi.Order;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

import java.util.List;
import java.util.Set;

public class OrderTest {

    @Test
    public void test01() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        URL url = URL.valueOf("xxx://localhost/ooo");
        // 加载“线上支付”的扩展类，即group为online的扩展类
        List<Order> activateExtensions = loader.getActivateExtension(url, "", "online");
        for (Order order : activateExtensions) {
            System.out.println(order.way());
        }
    }

    @Test
    public void test02() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        URL url = URL.valueOf("xxx://localhost/ooo");
        // 加载“线下支付”的扩展类，即group为offline的扩展类
        List<Order> activateExtensions = loader.getActivateExtension(url, "", "offline");
        for (Order order : activateExtensions) {
            System.out.println(order.way());
        }
    }

    @Test
    public void test03() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        URL url = URL.valueOf("xxx://localhost/ooo?xxx=alipay");
        // 加载“线下支付”的扩展类，即group为offline的扩展类
        // getActivateExtension()方法用于对扩展类进行选择（激活），
        // 在进行选择时，其第二个参数key与第三个参数group的关系是“或”
        List<Order> activateExtensions = loader.getActivateExtension(url, "xxx", "online");
        for (Order order : activateExtensions) {
            System.out.println(order.way());
        }
    }

    @Test
    public void test04() {
        ExtensionLoader<Order> loader = ExtensionLoader.getExtensionLoader(Order.class);
        // 获取Order接口的所有扩展类的扩展名
        Set<String> extensions = loader.getSupportedExtensions();
        System.out.println(extensions);
    }


}
