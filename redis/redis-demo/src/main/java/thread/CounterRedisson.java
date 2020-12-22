package thread;

import org.redisson.Redisson;
import redisson.RedissonUtils;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-09-07
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class CounterRedisson implements Runnable {

    private static UUID uuid = UUID.randomUUID();
    private static volatile int i = 0;
    private static int n = 100;
    private Redisson redisson;

    public CounterRedisson(Redisson redisson) {
        this.redisson = redisson;
    }

    @Override
    public void run() {
        String lockKey = uuid.toString();
        String threadName = Thread.currentThread().getName();
        while (true) {
            if (RedissonUtils.tryAcquire(redisson, lockKey, 10, 10)) {
                if (i < n) {
                    System.out.println(threadName + ":" + ++i);
                    RedissonUtils.release(redisson, lockKey);
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    RedissonUtils.release(redisson, lockKey);
                    break;
                }
            } else {
                try {
                    TimeUnit.MILLISECONDS.sleep(redisson.getLock(lockKey).remainTimeToLive());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
