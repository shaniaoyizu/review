package jedis;

import config.RedisConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created on 2020-09-07
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class JedisPoolManager {

    private static class JedisPoolInstance {
        private static JedisPoolConfig config = new JedisPoolConfig();
        static {
            config.setMaxTotal(1000);
            config.setMaxIdle(32);
            config.setMaxWaitMillis(100*1000);
            config.setTestOnBorrow(true);
        }
        private static JedisPool pool =
                new JedisPool(config, RedisConfig.REDIS_STAND_ALONE_HOST,RedisConfig.REDIS_STAND_ALONE_PORT);
    }

    /**
     * 获取redis连接池实例
     * @return
     */
    public static JedisPool getJedisPoolInstance() {
        return JedisPoolInstance.pool;
    }

    /**
     * 获取jedis实例
     * @return
     */
    public static Jedis getJedis(){
        return JedisPoolInstance.pool.getResource();
    }

    /**
     * jedis回收
     * @param jedis
     */
    public static void release(Jedis... jedis){
        if (jedis != null){
            for (Jedis j : jedis){
                j.close();
            }
        }
    }
}
