package com.kao.consumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1.引入依賴
//2.配置dubbo註冊衷心地此
//3.引用服務
//@Reference 利用這個註解在你要的屬性上註解，那就可以引用外部的類了。實現遠程調用。
@SpringBootApplication
public class ConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserApplication.class, args);
	}

}
