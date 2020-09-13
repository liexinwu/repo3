package com.java.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component      //默认时持久化的
@RabbitListener(queuesToDeclare = @Queue(value = "hello",durable = "true",autoDelete = "false")) //注意这里的参数都是string类型
public class HelloCustomer {

    @RabbitHandler
    public void receviel(String message){
        System.out.println("message="+message);
    }
}
