package com.home.spring.cloud.stream.binder.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.Binder;
import org.springframework.cloud.stream.binder.Binding;
import org.springframework.cloud.stream.binder.ConsumerProperties;
import org.springframework.cloud.stream.binder.ProducerProperties;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.util.Assert;

import javax.jms.*;

/**
 * @author: wulj13232
 * @description:
 * @date: Created in 18:27 2019/9/4
 * @modified by:
 */
public class ActiveMQMessageChannelBinder implements Binder<MessageChannel, ConsumerProperties,ProducerProperties> {

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public Binding<MessageChannel> bindConsumer(String name, String group, MessageChannel inboundBindTarget, ConsumerProperties consumerProperties) {
        ConnectionFactory factory = jmsTemplate.getConnectionFactory();
        try {
            Connection connection = factory.createConnection();
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(name);
            MessageConsumer messageConsumer = session.createConsumer(destination);
            messageConsumer.setMessageListener(message -> {
                if (message instanceof ObjectMessage){
                    ObjectMessage objectMessage = (ObjectMessage) message;
                    try {
                        Object object = objectMessage.getObject();
                        inboundBindTarget.send(new GenericMessage<Object>(object));
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e){

        }
        return null;
    }

    @Override
    public Binding<MessageChannel> bindProducer(String name, MessageChannel outputChannel, ProducerProperties producerProperties) {
        Assert.isInstanceOf(SubscribableChannel.class, outputChannel,
                "Binding is supported only for SubscribableChannel instances");
        SubscribableChannel subscribableChannel = (SubscribableChannel)outputChannel;
        subscribableChannel.subscribe(message -> {
            Object payload = message.getPayload();
            jmsTemplate.convertAndSend(name, payload);
        });
        return ()->{
            System.out.println("unbinding");
        };
    }
}
