package com.sunbc.rpc.service;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class AlipaySomeService implements SomeService {
    @Override
    public String hello(String name) {
        return name + "欢迎你，AlipaySomeService";
    }
}
