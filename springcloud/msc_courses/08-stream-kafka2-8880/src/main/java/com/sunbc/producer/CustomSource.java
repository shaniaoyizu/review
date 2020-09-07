package com.sunbc.producer;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created on 2020-09-07
 *
 * @author sunbc
 * @Describe 自定义管道
 * @since
 */

public interface CustomSource {
    String CHANNEL_NAME = "xxx";

    @Output(CustomSource.CHANNEL_NAME)
    MessageChannel output();
}
