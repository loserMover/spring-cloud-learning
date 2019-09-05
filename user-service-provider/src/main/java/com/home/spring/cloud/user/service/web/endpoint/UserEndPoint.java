package com.home.spring.cloud.user.service.web.endpoint;

import com.home.spring.cloud.user.service.web.bus.UserRemoteApplicationEvent;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.cloud.bus.endpoint.AbstractBusEndpoint;
import org.springframework.context.ApplicationEventPublisher;

@Endpoint(id = "bus-user")
public class UserEndPoint extends AbstractBusEndpoint {

    public UserEndPoint(ApplicationEventPublisher context, String appId) {
        super(context, appId);
    }

    @WriteOperation
    public void busUserWriteOperation(@Selector String destination){
        publish(new UserRemoteApplicationEvent(this, getInstanceId(), destination));
    }

    @WriteOperation
    public void busUser(){
        publish(new UserRemoteApplicationEvent(this, getInstanceId(), null));
    }
}
