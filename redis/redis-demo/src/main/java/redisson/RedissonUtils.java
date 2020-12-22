package redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-09-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class RedissonUtils {

    /**
     * 获取锁，如果获取不到会阻塞知道获取到锁
     * @param redisson
     * @param lockName 锁key
     * @param expireTime 锁过期时间 单位毫秒
     * @return
     */
    public static boolean acquire(Redisson redisson, String lockName, int expireTime) {
        RLock lock = redisson.getLock(lockName);
        lock.lock(expireTime,TimeUnit.MILLISECONDS);
        return true;
    }

    /**
     * 尝试获取锁
     *
     * @param redisson
     * @param lockName    锁key
     * @param expireTime  锁过期时间 单位毫秒
     * @param waitingTime 在这个时间内日尝试获取锁 单位毫秒
     * @return
     */
    public static boolean tryAcquire(Redisson redisson, String lockName, int expireTime, int waitingTime) {
        RLock lock = redisson.getLock(lockName);
        boolean result = false;
        try {
            result = lock.tryLock(waitingTime, expireTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 释放锁
     * @param redisson
     * @param lockName 锁key
     */
    public static void release(Redisson redisson,String lockName){
        RLock lock = redisson.getLock(lockName);
        if(lock.isLocked()){
            if(lock.isHeldByCurrentThread()){
                lock.unlock();
            }
        }
    }
}
