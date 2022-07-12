package com.zhx.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"email.fanout.queue"})
public class FanoutEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email fanout---- 收到了订单信息是：->" + message);
    }
}
