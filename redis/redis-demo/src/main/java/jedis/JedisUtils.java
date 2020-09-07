package jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.Collections;

/**
 * Created on 2020-09-07
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class JedisUtils {

    /**
     * 获取key对应的值
     *
     * @param key
     * @return
     */
    public static String get(Jedis jedis, String key) {
        String value = jedis.get(key);
        return value;
    }

    /**
     * 设置key和value
     *
     * @param key
     * @param value
     * @return
     */
    public static String set(Jedis jedis, String key, String value) {
        String s = jedis.set(key, value);
        return s;
    }

    /**
     * 使用redis的set实现分布式锁
     *
     * @param lockKey    锁key
     * @param requestId  请求ID,保证统一性 threadId 可以多次进入
     * @param expireTime
     * @return
     */
    public static Long getLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String result = jedis.set(lockKey, requestId, SetParams.setParams().px(expireTime).nx());
        if ("OK".equals(result)) {
            return 0l;
        }
        return jedis.ttl(lockKey);
    }

    /**
     * lua脚本实现分布式锁
     *
     * @param lockKey
     * @param requestId
     * @param expireTime
     * @return
     */
    public static Long getLockLua(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String script = "if redis.call('setnx',KEYS[1],ARGV[1]) == 1 then redis.call('pexpire',KEYS[1],ARGV[2]) return 0 " +
                "else return redis.call('ttl',KEYS[1]) end";
        Object result = jedis.eval(script, 1, lockKey, requestId, expireTime + "");
        if (Integer.valueOf(0).equals(result)) {
            return 0l;
        }
        return (Long) result;
    }

    /**
     * 释放锁
     *
     * @param lockKey
     * @param requestId
     */
    public static void releaseLock(Jedis jedis, String lockKey, String requestId) {
        if (requestId.equals(jedis.get(lockKey))) {
            jedis.del(lockKey);
        }
    }

    /**
     * Lua脚本释放锁
     *
     * @param lockKey
     * @param requestId
     * @return
     */
    public static boolean releaseLockLua(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get',KEYS[1]) == ARGV[1] then return redis.call('del',KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
        if (Integer.valueOf(1).equals(result)) {
            return true;
        }
        return false;
    }
}
