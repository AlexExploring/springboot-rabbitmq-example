package com.zhx.service.direct;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"sms.direct.queue"})
public class DirectSMSConsumer {

    @RabbitHandler
    public void receiveMessage(String message, Channel channel) {
        System.out.println("sms direct ---- 收到了订单信息是：->" + message);
    }
}
