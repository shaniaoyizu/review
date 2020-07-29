package com.sunbc.rpc.server;

import com.sunbc.rpc.register.ZKRegisterCenter;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RpcServerStarter {
    public static void main(String[] args) throws Exception {
        RpcServer rpcServer = new RpcServer();
        // 发布服务提供者
        rpcServer.publish(new ZKRegisterCenter(),"127.0.0.1:8888","com.sunbc.rpc.service");
        // 启动server
        rpcServer.start();
    }
}
