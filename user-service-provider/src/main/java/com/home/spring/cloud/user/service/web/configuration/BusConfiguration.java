package com.home.spring.cloud.user.service.web.configuration;

import com.home.spring.cloud.user.service.web.bus.UserRemoteApplicationEvent;
import com.home.spring.cloud.user.service.web.endpoint.UserEndPoint;
import org.springframework.cloud.bus.BusProperties;
import org.springframework.cloud.bus.ConditionalOnBusEnabled;
import org.springframework.cloud.bus.event.RefreshRemoteApplicationEvent;
import org.springframework.cloud.bus.jackson.RemoteApplicationEventScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@RemoteApplicationEventScan(basePackageClasses = UserRemoteApplicationEvent.class)
public class BusConfiguration {

    @EventListener
    public void onUserRemoteApplicationEvent(UserRemoteApplicationEvent event){
        System.out.printf("UserRemoteApplicationEvent - " +
                        " Source : %s , originService : %s , destinationService : %s \n",
                event.getSource(),
                event.getOriginService(),
                event.getDestinationService());
    }

    @EventListener
    public void onRefreshRemoteApplicationEvent(RefreshRemoteApplicationEvent event){
        System.out.printf("RefreshRemoteApplicationEvent - " +
                        " Source : %s , originService : %s , destinationService : %s \n",
                event.getSource(),
                event.getOriginService(),
                event.getDestinationService());
    }



    @Bean
    @ConditionalOnBusEnabled
    public UserEndPoint userEndPoint(ApplicationContext context,
                                     BusProperties bus){
        return new UserEndPoint(context, bus.getId());
    }
}
