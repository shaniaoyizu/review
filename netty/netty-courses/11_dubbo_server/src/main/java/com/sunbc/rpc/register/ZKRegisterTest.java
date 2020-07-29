package com.sunbc.rpc.register;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ZKRegisterTest {
    public static void main(String[] args) throws Exception {
        ZKRegisterCenter center = new ZKRegisterCenter();
        center.register("com.sunbc.service.SomeService","127.0.0.1:8888:com.sunbc.service.WechatSomeService");
        System.in.read();
    }
}
