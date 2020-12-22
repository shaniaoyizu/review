package com.sunbc.secondkill.service;


import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

/**
 * Created by feibabm on 2017/9/13 0013.
 */
public interface RedisService {

    RedisProperties.Jedis getResource();

    void returnResource(RedisProperties.Jedis jedis);

    void set(String key, String value);

    String get(String key);

    long incr(String key);

    long decr(String key);
}
