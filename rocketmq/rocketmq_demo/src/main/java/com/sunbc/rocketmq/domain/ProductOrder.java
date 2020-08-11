package com.sunbc.rocketmq.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2020-08-09
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ProductOrder implements Serializable {
    private static final long serialVersionUID = 8797222615251676830L;

    private Long orderId;
    private String type;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProductOrder() {
    }

    public ProductOrder(Long orderId, String type) {
        this.orderId = orderId;
        this.type = type;
    }

    public static List<ProductOrder> getOrderList(){
        List<ProductOrder> list = new ArrayList<>();
        list.add(new ProductOrder(111L,"创建订单"));
        list.add(new ProductOrder(222L,"创建订单"));
        list.add(new ProductOrder(111L,"支付订单"));
        list.add(new ProductOrder(222L,"支付订单"));
        list.add(new ProductOrder(111L,"完成订单"));
        list.add(new ProductOrder(333L,"创建订单"));
        list.add(new ProductOrder(222L,"完成订单"));
        list.add(new ProductOrder(333L,"支付订单"));
        list.add(new ProductOrder(333L,"完成订单"));
        return list;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "orderId=" + orderId +
                ", type='" + type + '\'' +
                '}';
    }
}
