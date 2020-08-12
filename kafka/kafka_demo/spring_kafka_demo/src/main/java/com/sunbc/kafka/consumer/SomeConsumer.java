package com.sunbc.kafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Component
public class SomeConsumer {

    @KafkaListener(topics = "${kafka.topic}")
    public void onMsg(String message){
        System.out.println("Kafka消费就收到的消息：" + message);
    }
}
