package jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;

/**
 * Created on 2020-09-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class JedisClusterManager {
    private static class JedisClusterInstance{
        private static HashSet<HostAndPort> clusterSet = new HashSet<>();
        private static GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        static {
            config.setMaxTotal(100);
            config.setMaxIdle(10);
            config.setMaxWaitMillis(2000);
            clusterSet.add(new HostAndPort("120.24.170.213",7001));
            clusterSet.add(new HostAndPort("120.24.170.213",7002));
            clusterSet.add(new HostAndPort("120.24.170.213",7003));
            clusterSet.add(new HostAndPort("120.24.170.213",7004));
            clusterSet.add(new HostAndPort("120.24.170.213",7005));
            clusterSet.add(new HostAndPort("120.24.170.213",7006));
//            String[] cluster = RedisConfig.REDIS_CLUSTER.split(",");
//            for (String redisStr : cluster){
//                String[] hostAndPort = redisStr.split(":");
//                clusterSet.add(new HostAndPort(hostAndPort[0],Integer.valueOf(hostAndPort[1])));
//            }
            System.out.println(clusterSet.toString());
        }
        private static JedisCluster jedisCluster =
                new JedisCluster(clusterSet,1000,2000,5,"123456",config);
    }

    public static JedisCluster getJedisClusterInstance(){
        return JedisClusterInstance.jedisCluster;
    }
}
