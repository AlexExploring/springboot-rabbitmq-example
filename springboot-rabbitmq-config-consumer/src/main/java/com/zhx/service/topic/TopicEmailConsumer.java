package com.zhx.service.topic;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"email.topic.queue"})
public class TopicEmailConsumer{
    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println(("email接收到了的订单信息是：" + message));
    }
}