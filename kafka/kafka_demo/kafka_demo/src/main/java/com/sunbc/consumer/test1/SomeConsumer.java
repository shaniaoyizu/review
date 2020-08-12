package com.sunbc.consumer.test1;

import kafka.utils.ShutdownableThread;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SomeConsumer extends ShutdownableThread {
    private KafkaConsumer<Integer,String> consumer;

    public SomeConsumer() {
        // 两个参数
        // 1)指定当前消费者名称
        // 2)指定消费过程是否会被中断
        super("KafkaConsumerTest", false);
        Properties properties = new Properties();
        // 指定kafka集群
        String brokers = "kafkaOS1:9092,kafkaOS2:9092,kafkaOS3:9092";
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,brokers);
        // 指定消费者组ID
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"cityGroup");
        // 开启自动提交 默认true
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        // 指定一次poll()从broker读取最大消息数
        properties.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,500);
        // 指定自动提交的超时时限 默认5s
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,100);
        // 指定消费者被broker认定为挂掉的时限。若broker在此时间内未收到当前消费者发送的心跳，则broker
        // 认为消费者已经挂掉。默认为10s
        properties.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,30000);
        // 指定两次心跳的时间间隔，默认为3s，一般不要超过session.timeout.ms的1/3
        properties.put(ConsumerConfig.HEARTBEAT_INTERVAL_MS_CONFIG,10000);
        // 当kafka中没有指定offset初值时，或指定的offset不存在时，从这里读取offset的值。其取值的意义为：
        // earliest:指定offset为第一条offset
        // latest:指定offset为最后一条offset
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        // 指定key与value的反序列化器
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(properties);
    }

    @Override
    public void doWork() {
        // 订阅消息主题
        consumer.subscribe(Collections.singletonList("cities"));
        // 从broker摘取消费。参数表示，若buffer中没有消费，消费者等待消费的时间
        // 0，表示没有消息什么也不返回
        // >0，表示当时间到后仍没有消息，则返回空
        ConsumerRecords<Integer, String> records = consumer.poll(1000);
        for (ConsumerRecord record : records){
            System.out.println("topic = " + record.topic());
            System.out.println("partition = " + record.partition());
            System.out.println("key = " + record.key());
            System.out.println("value = " + record.value());
        }
    }
}
