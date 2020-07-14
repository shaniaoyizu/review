package com.sunbc.cache.config;

import com.sunbc.cache.bean.Department;
import com.sunbc.cache.bean.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.net.UnknownHostException;

/**
 * Created on 2020-07-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Configuration
public class MyRedisConfig {

    @Bean
    public RedisTemplate<Object, Employee> emRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Employee.class));
        return template;
    }

    @Bean
    public RedisTemplate<Object, Department> deRedisTemplate(RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Department.class));
        return template;
    }

    @Primary
    @Bean
    public RedisCacheManager employeeCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration configuration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(
                                RedisSerializationContext
                                    .SerializationPair
                                    .fromSerializer(new Jackson2JsonRedisSerializer<>(Employee.class)));
        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(configuration).build();
    }

    @Bean
    public RedisCacheManager deptCacheManager(RedisConnectionFactory redisConnectionFactory){
        RedisCacheConfiguration configuration =
                RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(
                                RedisSerializationContext
                                    .SerializationPair
                                    .fromSerializer(new Jackson2JsonRedisSerializer<>(Department.class)));
        return RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(configuration).build();
    }
}
