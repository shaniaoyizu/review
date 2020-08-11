package com.sunbc.rocketmq.jms;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * Created on 2020-08-10
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class TransactionListenerImpl implements TransactionListener {
    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        System.out.println("===executeLocalTransaction===");
        String body = new String(msg.getBody());
        String keys = msg.getKeys();
        String transactionId = msg.getTransactionId();
        System.out.println("transactionId = " + transactionId + ",keys = " + keys + ",body = " + body);
        //TODO 执行本地事务开始

        //TODO 执行本地事务结束

        //二次确认消息，然后消费者可以消费
        if ("1".equals(arg)){
            return LocalTransactionState.COMMIT_MESSAGE;
        }
        //回滚消息，broker端会删除办消息
        if ("2".equals(arg)){
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        //broker会进行会查消息
        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        System.out.println("===checkLocalTransaction===");
        String body = new String(msg.getBody());
        String keys = msg.getKeys();
        String transactionId = msg.getTransactionId();
        System.out.println("transactionId = " + transactionId + ",keys = " + keys + ",body = " + body);

        //要么commit,要么rollback

        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
