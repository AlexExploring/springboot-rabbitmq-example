package com.zhx.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"email.direct.queue"})
public class DirectEmailConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("email direct---- 收到了订单信息是：->" + message);
    }
}
