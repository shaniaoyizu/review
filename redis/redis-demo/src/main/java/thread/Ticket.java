package thread;

import jedis.JedisPoolManager;
import jedis.JedisUtils;
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
public class Ticket implements Runnable {
    private Jedis jedis;
    private String key;

    public Ticket(Jedis jedis, String key) {
        this.jedis = jedis;
        this.key = key;
    }

    @Override
    public void run() {
        try{
            // 监视key
            jedis.watch(key);
            if (Integer.valueOf(JedisUtils.get(jedis, key)) > 0) {
                // 开启事务
                Transaction tx = jedis.multi();
                tx.incrBy(key, -1);
                List<Object> exec = tx.exec();
                if (exec != null) {
                    System.out.println(Thread.currentThread().getName() + " --- 购票成功");
                } else {
                    System.out.println(Thread.currentThread().getName() + " --- 票已卖完，抢票失败");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " --- 票已卖完，抢票失败");
            }
        }finally {
            JedisPoolManager.release(jedis);
        }
    }
}
