package com.sunbc.producer.test1;

import java.io.IOException;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class OneProducerTest {
    public static void main(String[] args) throws IOException {
        OneProducer producer = new OneProducer();
        producer.sendMsg();
        System.in.read();
    }
}
