package thread;

import jedis.JedisUtils;
import redis.clients.jedis.Jedis;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-09-07
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Counter implements Runnable {

    private static UUID uuid = UUID.randomUUID();
    private static volatile int i = 0;
    private static int n = 100;
    private Jedis jedis;

    public Counter(Jedis jedis) {
        this.jedis = jedis;
    }

    @Override
    public void run() {
        String lockKey = uuid.toString();
        String threadName = Thread.currentThread().getName();
        String requestId = lockKey + "_" + Thread.currentThread().getId();
        while (true) {
            Long lock = JedisUtils.getLock(jedis, lockKey, requestId, 2);
            if (Long.valueOf(0).equals(lock)) {
                if (i < n) {
                    System.out.println(threadName + " : " + ++i);
                    JedisUtils.releaseLock(jedis, lockKey, requestId);
                } else {
                    JedisUtils.releaseLock(jedis, lockKey, requestId);
                    break;
                }
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
