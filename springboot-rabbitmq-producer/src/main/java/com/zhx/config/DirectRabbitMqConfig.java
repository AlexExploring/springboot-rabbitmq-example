package com.zhx.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMqConfig{
    //1.声明注册fanout模式的交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_order_exchange",true,false);
    }
    //2.声明队列
    @Bean
    public Queue smsQueue1(){
        return new Queue("sms.direct.queue",true);
    }
    @Bean
    public Queue duanxinQueue1(){
        return new Queue("duanxin.direct.queue",true);
    }
    @Bean
    public Queue emailQueue1(){
        return new Queue("email.direct.queue",true);
    }
    //3.完成绑定关系
    @Bean
    public Binding smsBingding1(){
        return BindingBuilder.bind(smsQueue1()).to(directExchange()).with("sms");
    }

    @Bean
    public Binding duanxinBingding1(){
        return BindingBuilder.bind(duanxinQueue1()).to(directExchange()).with("duanxin");
    }
    @Bean
    public Binding emailBingding1(){
        return BindingBuilder.bind(emailQueue1()).to(directExchange()).with("email");
    }
}