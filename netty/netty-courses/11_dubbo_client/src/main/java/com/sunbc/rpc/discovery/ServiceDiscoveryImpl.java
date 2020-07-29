package com.sunbc.rpc.discovery;

import com.sunbc.rpc.balance.RandomLoadBalance;
import com.sunbc.rpc.constant.ZKConstant;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.util.List;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class ServiceDiscoveryImpl implements ServiceDiscovery {

    private CuratorFramework curator;
    List<String> invokers;

    public ServiceDiscoveryImpl() {
        curator = CuratorFrameworkFactory.builder()
                .connectString(ZKConstant.ZK_CLUSTER)
                .connectionTimeoutMs(10000)
                .sessionTimeoutMs(4000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 10))
                .build();
        curator.start();
    }

    @Override
    public String discovery(String serviceName) throws Exception {
        String servicePath = ZKConstant.ZK_DUBBO_ROOT_PATH + "/" + serviceName;
        invokers = curator.getChildren().forPath(servicePath);
        if (invokers.size() == 0){
            return  null;
        }

        // 若只有一个提供者，则直接返回，不用负载均衡
        if (invokers.size() == 1){
            return invokers.get(0);
        }
        // 为服务名称节点添加watcher监听
        registerWatcher(servicePath);
        return new RandomLoadBalance().choose(invokers);
    }

    private void registerWatcher(String servicePath) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(curator, servicePath,true);
        // 添加cache子节点列表变更的监听
        cache.getListenable().addListener(((client, event) -> {
            invokers = curator.getChildren().forPath(servicePath);
        }));
        cache.start();
    }
}
