package com.abc.spi.extension;

import com.abc.spi.Order;
import org.apache.dubbo.common.extension.Activate;

// @Activate中的group与value用于对当前扩展类进行标识与限定，它们的关系是“与”
// 即在选择该扩展类时，必须是这两个条件同时满足才可选择到它
@Activate(group = "online", value = "wechat")
public class WeChatOrder implements Order {
    @Override
    public String way() {
        System.out.println("--- 微信way() ---");
        return "微信支付方式";
    }
}
