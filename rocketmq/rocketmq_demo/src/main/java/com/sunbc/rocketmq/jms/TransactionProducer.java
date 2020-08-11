package com.sunbc.rocketmq.jms;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * Created on 2020-08-09
 *
 * @author sunbc
 * @Describe
 * @since
 */
@Component
public class TransactionProducer {

    private String producerGroup = "transaction_producer_group";

    private TransactionListener transactionListener = new TransactionListenerImpl();

    private TransactionMQProducer producer;

    private ExecutorService executorService = new ThreadPoolExecutor(2, 5, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(2000), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("client-transaction-msg-check-thread");
            return thread;
        }
    });

    public TransactionProducer(){
        producer = new TransactionMQProducer(producerGroup);
        producer.setNamesrvAddr(JmsConfig.NAME_SERVER_ADDR);
        producer.setTransactionListener(transactionListener);
        producer.setExecutorService(executorService);
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

    public TransactionMQProducer getProducer(){
        return producer;
    }
}
