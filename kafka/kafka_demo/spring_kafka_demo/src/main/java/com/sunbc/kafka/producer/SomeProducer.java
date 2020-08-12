package com.sunbc.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class SomeProducer {
    @Autowired
    private KafkaTemplate<String,String> producer;

    @Value("${kafka.topic}")
    private String topic;

    @PostMapping("/msg/send")
    public String sendMsg(@RequestParam("message") String message){
        producer.send(topic,message);
        return "send success";
    }
}
