package com.kao.providerticket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//1.將提供紙註冊到中心，引入dubbo和zkclient相關依賴
//2.配置dubbo的掃描包和註冊衷心地此
//3.使用@Service發布服務
@SpringBootApplication
public class ProviderTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProviderTicketApplication.class, args);
	}

}
