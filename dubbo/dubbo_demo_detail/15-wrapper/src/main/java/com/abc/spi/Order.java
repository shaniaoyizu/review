package com.abc.spi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI("alipay")
public interface Order {
    String way();

    @Adaptive
    String pay(URL url);
}
