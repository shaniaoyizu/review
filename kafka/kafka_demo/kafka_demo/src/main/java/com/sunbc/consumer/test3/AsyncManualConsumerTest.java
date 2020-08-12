package com.sunbc.consumer.test3;

import java.io.IOException;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class AsyncManualConsumerTest {
    public static void main(String[] args) throws IOException {
        AsyncManualConsumer consumer = new AsyncManualConsumer();
        consumer.start();
        System.in.read();
    }
}
