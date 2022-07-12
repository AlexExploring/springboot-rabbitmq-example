package com.zhx.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitMqConfig {
    //1.声明注册topic模式的交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic_order_exchange",true,false);
    }
    //2.声明队列
    @Bean
    public Queue smsQueue2(){
        return new Queue("sms.topic.queue",true);
    }
    @Bean
    public Queue duanxinQueue2(){
        return new Queue("duanxin.topic.queue",true);
    }
    @Bean
    public Queue emailQueue2(){
        return new Queue("email.topic.queue",true);
    }
    //3.完成绑定关系
    @Bean
    public Binding smsBingding2(){
        return BindingBuilder.bind(smsQueue2()).to(topicExchange()).with("com.#");
    }
    @Bean
    public Binding duanxinBingding2(){
        return BindingBuilder.bind(duanxinQueue2()).to(topicExchange()).with("#.duanxin.#");
    }
    @Bean
    public Binding emailBingding2(){
        return BindingBuilder.bind(emailQueue2()).to(topicExchange()).with("*.email.#");
    }
}


