package com.java.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = "topic",name = "topics"),
                    key = {"user.*","*.user.*"}
            )
    })
    public void receivel1(String message){
        System.out.println("message1："+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = "topic",name = "topics"),
                    key = {"user.#"}
            )
    })
    public void receivel2(String message){
        System.out.println("message2："+message);
    }
}
