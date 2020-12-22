package redisson;

import org.redisson.Redisson;
import org.redisson.config.Config;

/**
 * Created on 2020-09-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RedissonManager {
    private static class RedissonInstance {
        private static Config config = new Config();
        static {
            config.useClusterServers()
                    // 集群状态扫描间隔
                    .setScanInterval(2000)
                    .setPassword("123456")
                    .addNodeAddress("redis://120.24.170.213:7001")
                    .addNodeAddress("redis://120.24.170.213:7002")
                    .addNodeAddress("redis://120.24.170.213:7003")
                    .addNodeAddress("redis://120.24.170.213:7004")
                    .addNodeAddress("redis://120.24.170.213:7005")
                    .addNodeAddress("redis://120.24.170.213:7006");
        }
        private static Redisson redisson = (Redisson) Redisson.create(config);
    }

    public static Redisson getRedissonInstance() {
        return RedissonInstance.redisson;
    }
}
