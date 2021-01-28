package com.kao.amqp.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAmqpConfig {

    @Bean
    public MessageConverter messageConverter() {
        //轉化數據為json格式
        return new Jackson2JsonMessageConverter();
    }
}
