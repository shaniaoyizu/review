package com.sunbc.rpc.register;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface RegisterCenter {
    /**
     *
     * @param serviceName 业务接口
     * @param serviceAddress ip:port:实现类名
     */
    void register(String serviceName,String serviceAddress) throws Exception;
}
