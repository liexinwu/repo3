package com.java.test;

import com.java.RabbitmqSpringbootApplication;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RabbitmqSpringbootApplication.class)
public class TestRabbitmq {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testHello(){
        rabbitTemplate.convertAndSend("hello","hello world");
    }

    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work模型"+i);
        }
    }

    @Test
    public void testfanout(){
        rabbitTemplate.convertAndSend("logs","","fanout模型发送的消息");
    }

    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","error","发送info的key的路由信息");
    }

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save.haha","发送user.save的路由信息");
    }
}
