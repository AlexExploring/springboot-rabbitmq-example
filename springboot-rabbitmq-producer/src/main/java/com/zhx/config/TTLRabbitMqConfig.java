package com.zhx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class TTLRabbitMqConfig {
    //1.声明注册fanout模式的交换机
    @Bean
    public DirectExchange ttlDirectExchange(){
        return new DirectExchange("ttl_direct_order_exchange",true,false);
    }

    /**
     * 一个有过期时间的队列
     */
    @Bean
    public Queue ttlSmsQueue(){
        //参数 args
        Map<String,Object> args = new HashMap<>();
        //设置过期时间
        args.put("x-message-ttl",5000);
        //指定死信队列
        args.put("x-dead-letter-exchange","dead_direct_exchange");
        args.put("x-dead-letter-routing-key","dead");
        //队列最大长度
        //args.put("x-max-length",5);
        return new Queue("ttl.sms.direct.queue",true,false,false,args);
    }

    /**
     * 一个普通队列, 在消息中设置过期时间
     */
    @Bean
    public Queue ttlMessageSmsQueue(){
        return new Queue("ttl.message.sms.direct.queue",true);
    }

    @Bean
    public Binding ttlSmsBinding() {
        return BindingBuilder.bind(ttlSmsQueue()).to(ttlDirectExchange()).with("ttl");
    }

    @Bean
    public Binding ttlMessageSmsBinding() {
        return BindingBuilder.bind(ttlMessageSmsQueue()).to(ttlDirectExchange()).with("ttlmessage");
    }
}
