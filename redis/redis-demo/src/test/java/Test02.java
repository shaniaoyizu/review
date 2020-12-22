import org.junit.Test;
import org.redisson.Redisson;
import redisson.RedissonManager;
import thread.CounterRedisson;

/**
 * Created on 2020-09-08
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test02 {

    @Test
    public void test01() throws InterruptedException {
        Redisson redisson = RedissonManager.getRedissonInstance();
        Thread thread1 = new Thread(new CounterRedisson(redisson),"thread-1");
        Thread thread2 = new Thread(new CounterRedisson(redisson),"thread-2");
        Thread thread3 = new Thread(new CounterRedisson(redisson),"thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }
}
