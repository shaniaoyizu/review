package com.sunbc.rpc.consumer;

import com.sunbc.rpc.client.RpcProxy;
import com.sunbc.rpc.service.SomeService;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RpcConsumer {
    public static void main(String[] args) {
        SomeService someService = RpcProxy.create(SomeService.class);
        System.out.println(someService.hello("开课吧"));
        System.out.println(someService.hashCode());
    }
}
