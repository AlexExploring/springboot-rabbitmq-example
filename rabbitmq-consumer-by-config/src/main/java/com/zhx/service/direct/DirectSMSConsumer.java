package com.zhx.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"sms.direct.queue"})
public class DirectSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("sms direct ---- 收到了订单信息是：->" + message);
    }
}
