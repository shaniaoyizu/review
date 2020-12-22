package thread;

import jedis.JedisPoolManager;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;

/**
 * Created on 2020-09-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TicketList implements Runnable {
    private Jedis jedis;
    private String key;

    public TicketList(Jedis jedis, String key) {
        this.jedis = jedis;
        this.key = key;
    }

    @Override
    public void run() {
        try {
            jedis.watch(key);
            if (jedis.llen(key) > 0) {
                Transaction tx = jedis.multi();
                tx.lpop(key);
                List<Object> exec = tx.exec();
                if (exec != null) {
                    System.out.println(Thread.currentThread().getName() + " --- 购票成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + " --- 票已卖完，抢票失败");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " --- 票已卖完，抢票失败");
            }
        } finally {
            JedisPoolManager.release(jedis);
        }
    }
}
