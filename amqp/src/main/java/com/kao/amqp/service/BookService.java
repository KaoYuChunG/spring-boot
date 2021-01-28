package com.kao.amqp.service;

import com.kao.amqp.bean.Book;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    //要開啟Rabbit模式 no application
    @RabbitListener( queues = "kao.news")
    public void receive(Book book ) {
        System.out.println("receive"+book);
    }

    //如要有header and body就用message 來接收數據
    @RabbitListener(queues = "kao")
    public void receiveWithHeader(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
