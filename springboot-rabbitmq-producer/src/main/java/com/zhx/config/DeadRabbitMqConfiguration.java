package com.zhx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadRabbitMqConfiguration{
    //1.声明注册direct模式的交换机
    @Bean
    public DirectExchange deadDirectExchange(){
        return new DirectExchange("dead_direct_exchange",true,false);
    }

    //2.队列的过期时间
    @Bean
    public Queue deadQueue() {
        return new Queue("dead.direct.queue",true);
    }

    @Bean
    public Binding deadbinds(){
        return BindingBuilder.bind(deadQueue()).to(deadDirectExchange()).with("dead");
    }
}

