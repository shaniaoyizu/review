package com.sunbc.rpc.register;

import com.sunbc.rpc.constant.ZKConstant;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ZKRegisterCenter implements RegisterCenter {

    private CuratorFramework curator;

    public ZKRegisterCenter() {
        curator = CuratorFrameworkFactory.builder()
                .connectString(ZKConstant.ZK_CLUSTER)
                .connectionTimeoutMs(10000)
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000,10))
                .build();
        curator.start();
    }

    @Override
    public void register(String serviceName, String serviceAddress) throws Exception {
        // 创建持久节点

        // 要创建的服务名称的节点名称
        String servicePath = ZKConstant.ZK_DUBBO_ROOT_PATH + "/" + serviceName;
        if (curator.checkExists().forPath(servicePath) == null){
            curator.create()
                    .creatingParentsIfNeeded()
                    .withMode(CreateMode.PERSISTENT)
                    .forPath(servicePath);
        }

        // 创建临时节点
        String providerPath = servicePath + "/" + serviceAddress;
        if (curator.checkExists().forPath(providerPath) == null){
            String path = curator.create()
                    .withMode(CreateMode.EPHEMERAL)
                    .forPath(providerPath);
            System.out.println(path);
        }
    }
}
