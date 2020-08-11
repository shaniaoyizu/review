package com.sunbc.rocketmq.jms;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Component;

/**
 * Created on 2020-08-09
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Component
public class PayProducer {

    private String producerGroup = "pay_group";

    private DefaultMQProducer producer;

    public PayProducer(){
        producer = new DefaultMQProducer(producerGroup);
        producer.setRetryTimesWhenSendFailed(3);
        producer.setNamesrvAddr(JmsConfig.NAME_SERVER_ADDR);
        start();
    }

    public void start(){
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public void shutdown(){
        this.producer.shutdown();
    }

    public DefaultMQProducer getProducer(){
        return producer;
    }
}
