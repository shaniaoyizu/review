package com.sunbc.rpc.discovery;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface ServiceDiscovery {
    /**
     *
     * @param serviceName 服务名称
     * @return 返回负载均衡后的主机信息，格式是ip:port:实现类名
     */
    String discovery(String serviceName) throws Exception;
}
