package com.home.spring.cloud.stream.consumer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 18:19 2019/9/3
 * @modified by:
 */
public interface MessageSink {

    String INPUT = "spring-cloud-stream";

    /**
     * 监听MQ通道
     * @return
     */
    @Input(value=INPUT)
    SubscribableChannel inputMessage();

    @Input("spring-cloud-stream-active")
    SubscribableChannel inputActiveMQMessage();
}
