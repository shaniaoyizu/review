package com.sunbc.producer.test3;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SomeProducerBatch {
    // 第一个泛型：当前生产者所生产消息的key
    // 第二个泛型：当前生产者所生产的消息本身
    private KafkaProducer<Integer, String> producer;

    public SomeProducerBatch() {
        Properties properties = new Properties();
        // 指定kafka集群
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafkaOS1:9092,kafkaOS2:9092,kafkaOS3:9092");
        // 指定key与value的序列化器
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        // 指定生产者每10条向broker发送一次
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 10);
        // 指定生产者每50ms向broker发送一次
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 50);
        this.producer = new KafkaProducer<>(properties);
    }

    public void sendMsg() {
        for (int i = 0; i < 50; i++) {
            int k = i;
            ProducerRecord<Integer, String> record = new ProducerRecord<>("cities", "city-" + i);
            producer.send(record, ((metadata, exception) -> {
                System.out.println("i = " + k);
                System.out.println("topic = " + metadata.topic());
                System.out.println("partition = " + metadata.partition());
                System.out.println("offset = " + metadata.offset());
            }));
        }
    }
}
