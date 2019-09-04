package com.home.spring.cloud.stream.binder.activemq;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.cloud.stream.binder.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 19:17 2019/9/4
 * @modified by:
 */
@Configuration
@ConditionalOnMissingBean(Binder.class)
public class ActiveMQStreamBinderAutoConfiguration {
    @Bean
    public ActiveMQMessageChannelBinder activeMQMessageChannelBinder(){
        return new ActiveMQMessageChannelBinder();
    }
}
