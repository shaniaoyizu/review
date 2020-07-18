package com.abc.spi;

import org.apache.dubbo.common.extension.SPI;

@SPI("alipay")
public interface Order {
    String way();
}
