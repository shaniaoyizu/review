import jedis.JedisClusterManager;
import jedis.JedisPoolManager;
import jedis.JedisUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import thread.Counter;
import thread.CounterLua;
import thread.Ticket;
import thread.TicketList;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created on 2020-09-07
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class Test01 {

    @Test
    public void test01() {
        JedisPool pool01 = JedisPoolManager.getJedisPoolInstance();
        JedisPool pool02 = JedisPoolManager.getJedisPoolInstance();
        System.out.println(pool01 == pool02);
    }

    @Test
    public void test02() {
        Jedis jedis = JedisPoolManager.getJedis();
        System.out.println(JedisUtils.set(jedis, "k1", "v1"));
        System.out.println(JedisUtils.get(jedis, "k1"));
    }

    @Test
    public void test03() throws InterruptedException {
        Thread thread1 = new Thread(new Counter(JedisPoolManager.getJedis()), "Thread_1");
        Thread thread2 = new Thread(new Counter(JedisPoolManager.getJedis()), "Thread_2");
        Thread thread3 = new Thread(new Counter(JedisPoolManager.getJedis()), "Thread_3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }

    @Test
    public void test04() throws InterruptedException {
        Thread thread1 = new Thread(new CounterLua(JedisPoolManager.getJedis()), "Thread_1");
        Thread thread2 = new Thread(new CounterLua(JedisPoolManager.getJedis()), "Thread_2");
        Thread thread3 = new Thread(new CounterLua(JedisPoolManager.getJedis()), "Thread_3");
        thread1.start();
        thread2.start();
        thread3.start();
        thread1.join();
        thread2.join();
        thread3.join();
    }

    @Test
    public void test05() {
        JedisPoolManager.getJedis().set("ticket", "10");
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            service.execute(new Ticket(JedisPoolManager.getJedis(), "ticket"));
        }
        service.shutdown();
    }

    @Test
    public void test06(){
        String key = "ticketList";
        JedisPoolManager.getJedis().lpush(key,"1","2","3","4","5","6","7","8","9","10");
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 50; i++) {
            service.execute(new TicketList(JedisPoolManager.getJedis(), key));
        }
        service.shutdown();
    }

    @Test
    public void test07(){
        JedisCluster cluster = JedisClusterManager.getJedisClusterInstance();
        cluster.set("jc","1");
    }
}
