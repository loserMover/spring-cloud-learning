package com.home.spring.cloud.stream.provider.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 18:19 2019/9/3
 * @modified by:
 */
public interface MessageSource {

    public String OUTPUT = "spring-cloud-stream";

    /**
     * 绑定通道
     * @return
     */
    @Output(value=OUTPUT)
    MessageChannel outputMessage();
}
