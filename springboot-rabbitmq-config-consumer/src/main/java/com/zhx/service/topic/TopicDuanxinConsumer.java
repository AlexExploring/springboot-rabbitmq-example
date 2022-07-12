package com.zhx.service.topic;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"duanxin.topic.queue"})
public class TopicDuanxinConsumer {

    @RabbitHandler
    public void reviceMessage(String message){
        System.out.println(("duanxin接收到了的订单信息是：" + message));
    }
}