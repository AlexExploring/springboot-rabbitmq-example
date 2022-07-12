package com.zhx.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"sms.fanout.queue"})
public class FanoutSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms fanout---- 收到了订单信息是：->" + message);
    }
}
