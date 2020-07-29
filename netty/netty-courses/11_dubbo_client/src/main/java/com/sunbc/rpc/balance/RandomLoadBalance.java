package com.sunbc.rpc.balance;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created on 2020-07-28
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RandomLoadBalance implements LoadBalance {
    @Override
    public String choose(List<String> servers) {
        return servers.get(ThreadLocalRandom.current().nextInt(servers.size()));
    }
}
