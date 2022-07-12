package com.zhx.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = {"duanxin.direct.queue"})
public class DirectDuanxinConsumer {

    @RabbitHandler
    public void receiveMessage(String message) {
        System.out.println("duanxin direct---- 收到了订单信息是：->" + message);
    }
}
