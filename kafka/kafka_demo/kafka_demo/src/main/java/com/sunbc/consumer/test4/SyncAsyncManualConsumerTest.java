package com.sunbc.consumer.test4;

import java.io.IOException;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SyncAsyncManualConsumerTest {
    public static void main(String[] args) throws IOException {
        SyncAsyncManualConsumer consumer = new SyncAsyncManualConsumer();
        consumer.start();
        System.in.read();
    }
}
