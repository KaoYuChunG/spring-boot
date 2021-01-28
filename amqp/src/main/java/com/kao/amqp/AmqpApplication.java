package com.kao.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//可使用amqpAdmin來管理創建和刪除 queue, exchange, binding
@EnableRabbit
@SpringBootApplication
public class AmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmqpApplication.class, args);
	}

}
