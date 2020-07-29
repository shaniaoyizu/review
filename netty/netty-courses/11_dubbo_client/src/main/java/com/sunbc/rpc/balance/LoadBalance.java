package com.sunbc.rpc.balance;

import java.util.List;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public interface LoadBalance {
    /**
     *
     * @param servers
     * @return
     */
    String choose(List<String> servers);
}
