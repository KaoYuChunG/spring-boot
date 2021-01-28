package com.kao.amqp;

import com.kao.amqp.bean.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
class AmqpApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	//一些amqpadmin 的操作
	@Test
	public void createExchange() {
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
		amqpAdmin.declareQueue(new Queue("amqpadmin.queue",true));
		//隊前兩項做綁定的動作

		amqpAdmin.declareBinding(new Binding("amqpadmin.queue",Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqp.a",null));
	}
	// 點對點
	@Test
	void contextLoads() {
		//messagem 自訂，有header and body
//		rabbitTemplate.send(exchage, routeKey, message);

		//只需傳入要發送的對象，會自動序列化發送給rabbitmq
//		rabbitTemplate.convertAndSend(exchage, routeKey, object);
		Map<String,Object> map = new HashMap<>();
		map.put("msg","primeiro mensagem");
		map.put("data", Arrays.asList("hello",123,true));
		rabbitTemplate.convertAndSend("exchange.direct", "kao.news",map);
	}

//	用對象發布消息
	@Test
	void testWithClass() {
		Book book = new Book("raio", "kao");
		rabbitTemplate.convertAndSend("exchange.direct", "kao.news",book);
	}


//	接收數據
//	接收對象方式測試也是在這
	@Test
	public void receive() {
		Object o = rabbitTemplate.receiveAndConvert("kao.news");
		System.out.println(o.getClass());
		System.out.println(o);

	}

//	廣播
	@Test
	public void sendMsg() {
		Book book = new Book("sol", "chun");
		//廣播不用給路徑
		rabbitTemplate.convertAndSend("exchange.fanout", "", book);
	}
}
