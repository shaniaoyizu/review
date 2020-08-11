package com.sunbc.rocketmq.controller;

import com.sunbc.rocketmq.domain.ProductOrder;
import com.sunbc.rocketmq.jms.JmsConfig;
import com.sunbc.rocketmq.jms.PayProducer;
import com.sunbc.rocketmq.jms.TransactionProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created on 2020-08-09
 *
 * @author sunbc
 * @Describe
 * @since
 */
@RestController
public class PayController {

    @Autowired
    private PayProducer payProducer;

    @Autowired
    private TransactionProducer transactionProducer;

    @RequestMapping("/api/v1/pay_cb")
    public Object callBack(String text) throws Exception {
        Message message = new Message(JmsConfig.TOPIC, "tiger", "6688", ("hello,world = " + text).getBytes());
        //延迟消息
//        message.setDelayTimeLevel(2);
        // SYNC
//        payProducer.getProducer().send(message);
        //ASYNC
//        payProducer.getProducer().send(message, new SendCallback() {
//            @Override
//            public void onSuccess(SendResult sendResult) {
//
//            }
//
//            @Override
//            public void onException(Throwable e) {
//                //补偿机制
//            }
//        });
        //SendOneWay
//        payProducer.getProducer().send(message);

        payProducer.getProducer().send(message, (mqs, msg, arg) -> {

            return null;
        }, 0);
        return new HashMap<>();
    }

    @RequestMapping("/order")
    public Object order(String orderId) throws Exception {
        Message message = new Message(JmsConfig.TOPIC, "tiger", "6688", ("hello,world = " + orderId).getBytes());
        // arg参数值为orderId
        payProducer.getProducer().send(message, (mqs, msg, arg) -> {
            Integer queueNum = Integer.valueOf(arg.toString()) % mqs.size();
            //返回指定要发送的队列
            return mqs.get(queueNum);
        }, orderId);
        return new HashMap<>();
    }

    @RequestMapping("/send/order")
    public Object sendOrder() throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        List<ProductOrder> orderList = ProductOrder.getOrderList();
        for (int i = 0; i < orderList.size(); i++) {
            ProductOrder order = orderList.get(i);
            Message message = new Message(JmsConfig.ORDERLY_TOPIC, "", order.getOrderId() + "", order.toString().getBytes());
            SendResult result = payProducer.getProducer().send(message, (mqs, msg, arg) -> {
                Long id = (Long) arg;
                long index = id % mqs.size();
                return mqs.get((int) index);
            }, order.getOrderId());
            System.out.printf("发送结果=%s,msg=%s,orderId=%s,type=%s\n",
                    result.getSendStatus(), result.toString(), order.getOrderId(), order.getType());
        }
        return new HashMap<>();
    }

    @RequestMapping("/filter")
    public Object filterMessage(String tag) throws Exception {
        Message message = new Message(JmsConfig.TOPIC, tag, "6688", ("hello,world = " + tag).getBytes());
        SendResult result = payProducer.getProducer().send(message);
        System.out.printf("发送结果=%s,result=%s\n", result.getSendStatus(), result.toString());
        return new HashMap<>();
    }

    @RequestMapping("/filter/sql")
    public Object filterSQLMessage(String tag, String amount) throws Exception {
        Message message = new Message(JmsConfig.TOPIC, tag, "6688", ("hello,world = " + tag).getBytes());
        message.putUserProperty("amount", amount);
        SendResult result = payProducer.getProducer().send(message);
        System.out.printf("发送结果=%s,result=%s\n", result.getSendStatus(), result.toString());
        return new HashMap<>();
    }

    @RequestMapping("/transaction")
    public Object transactionMessage(String tag, String otherParam) throws MQClientException {
        Message message = new Message(JmsConfig.TRANSACTION_TOPIC, tag, tag + otherParam + "_key", tag.getBytes());
        TransactionSendResult sendResult = transactionProducer.getProducer().sendMessageInTransaction(message, otherParam);
        System.out.printf("发送结果=%s,result=%s\n", sendResult.getSendStatus(), sendResult.toString());
        return new HashMap<>();
    }
}
