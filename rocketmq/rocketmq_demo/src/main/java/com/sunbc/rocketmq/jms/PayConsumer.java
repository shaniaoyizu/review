package com.sunbc.rocketmq.jms;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.MessageSelector;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
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
public class PayConsumer {

    private String consumerGroup = "pay_consumer_group";
    private DefaultMQPushConsumer consumer;

    public PayConsumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.setNamesrvAddr(JmsConfig.NAME_SERVER_ADDR);
//        consumer.subscribe(JmsConfig.TOPIC, "order_pay || order_finish");
        consumer.subscribe(JmsConfig.TOPIC, MessageSelector.bySql("amount > 5"));
        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            MessageExt msg = msgs.get(0);
//            int times = msg.getReconsumeTimes();
//            System.out.println("重试次数=" + times);
            try {
//                System.out.printf("%s Receive New Messages: %s \n", Thread.currentThread().getName(), msg);
                String topic = msg.getTopic();
                String body = new String(msg.getBody(), "utf-8");
                String tags = msg.getTags();
                String keys = msg.getKeys();
//                if ("6688".equals(keys)){
//                    throw new Exception();
//                }
                System.out.println("topic = " + topic + ", body = " + body + ", tags = " + tags + ", keys = " + keys);
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            } catch (Exception e) {
                System.out.println("消费异常");
//                if (times > 2){
//                    System.out.println("重试次数大于2，记录数据库，发短信通知开发人员或者营运人员");
//                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//                }
                e.printStackTrace();
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        });
        consumer.start();
        System.out.println("consumer starting...");
    }
}
