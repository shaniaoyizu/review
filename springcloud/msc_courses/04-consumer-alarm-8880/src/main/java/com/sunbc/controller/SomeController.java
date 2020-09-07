package com.sunbc.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sunbc.bean.Depart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020-09-03
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
@RequestMapping("/consumer/depart")
public class SomeController {

    //使用微服务名称来来从eureka server查找
    private final static String SERVICE_PROVIDER = "http://msc-provider-depart";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private ForkJoinPool pool = new ForkJoinPool(5);

    @PostMapping("/")
    public boolean saveHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER + "/provider/depart/";
        return restTemplate.postForObject(url,depart,Boolean.class);
    }

    @DeleteMapping("/{id}")
    public void deleteHandler(@PathVariable("id") Integer id){
        String url = SERVICE_PROVIDER + "/provider/depart/" + id;
        restTemplate.delete(url,id);
    }

    @PutMapping("/")
    public void updateHandler(@RequestBody Depart depart){
        String url = SERVICE_PROVIDER + "/provider/depart/";
        restTemplate.put(url,depart);
    }

    @HystrixCommand(fallbackMethod = "getHystrixHandler")
    @GetMapping("/{id}")
    public Depart getHandler(@PathVariable("id") Integer id, HttpServletRequest request){
        String url = SERVICE_PROVIDER + "/provider/depart/" + id;
        return restTemplate.getForObject(url,Depart.class);
    }

    //定义服务降级方法，即响应给客户端的备选方案
    public Depart getHystrixHandler(@PathVariable("id") Integer id, HttpServletRequest request){
        // 向管理员发出警报
        String ip = request.getLocalAddr();
        // 指定存放到Redis中的key为“ip_发生降级服务的方法名”
        String key = ip + "getHystrixHandler";
        alarm(key);

        Depart depart = new Depart();
        depart.setId(id);
        depart.setName("no this depart");
        return depart;
    }

    // 降级发生后的报警
    private void alarm(String key) {
        BoundValueOperations<String, String> ops = redisTemplate.boundValueOps(key);
        String value = ops.get();
        if (value == null){
            synchronized (this){
                value = ops.get();
                if (value == null){
                    // 发送短信
                    sendMsg(key);
                    value = "已发生服务降级";
                    ops.set(value,10, TimeUnit.SECONDS);
                }
            }
        }
    }


    private void sendMsg(String key) {
        pool.submit(() -> {
            System.out.println("发送服务降级警报：" + key);
        });
    }

    @GetMapping("/")
    public List<Depart> listHandler(){
        String url = SERVICE_PROVIDER + "/provider/depart/";
        return restTemplate.getForObject(url,List.class);
    }
}
