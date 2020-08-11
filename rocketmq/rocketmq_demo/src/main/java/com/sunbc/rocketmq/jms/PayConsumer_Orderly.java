package com.sunbc.rocketmq.jms;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * Created on 2020-08-09
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Component
public class PayConsumer_Orderly {

    private String consumerGroup = "pay_consumer_orderly_group";
    private DefaultMQPushConsumer consumer;

    public PayConsumer_Orderly() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        consumer.setNamesrvAddr(JmsConfig.NAME_SERVER_ADDR);
        consumer.subscribe(JmsConfig.ORDERLY_TOPIC, "*");
        consumer.registerMessageListener((MessageListenerOrderly) (msgs, context) -> {
            MessageExt msg = msgs.get(0);
            try {
                String topic = msg.getTopic();
                String body = new String(msg.getBody(), "utf-8");
                String tags = msg.getTags();
                String keys = msg.getKeys();
                if ("6688".equals(keys)){
                    throw new Exception();
                }
                System.out.println("topic = " + topic + ", body = " + body + ", tags = " + tags + ", keys = " + keys);
                return ConsumeOrderlyStatus.SUCCESS;
            } catch (Exception e) {
                e.printStackTrace();
                return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
            }
        });
        consumer.start();
        System.out.println("consumer starting...");
    }
}
