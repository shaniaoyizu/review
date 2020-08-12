package com.sunbc.consumer.test2;

import java.io.IOException;

/**
 * Created on 2020-08-12
 *
 * @author sunbc
 * @Describe
 * @since
 */
public class SyncManualConsumerTest {
    public static void main(String[] args) throws IOException {
        SyncManualConsumer consumer = new SyncManualConsumer();
        consumer.start();
        System.in.read();
    }
}
