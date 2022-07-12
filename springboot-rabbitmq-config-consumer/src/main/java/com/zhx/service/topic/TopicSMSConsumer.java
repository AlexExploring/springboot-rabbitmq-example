package com.zhx.service.topic;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"sms.topic.queue"})
public class TopicSMSConsumer{
    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println(("sms接收到了的订单信息是：" + message));
    }
}

