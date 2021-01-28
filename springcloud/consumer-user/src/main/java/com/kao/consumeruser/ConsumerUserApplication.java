package com.kao.consumeruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient //開啟發現服務功能
@SpringBootApplication
public class ConsumerUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerUserApplication.class, args);
	}

//	負載均衡機制 用於針對當有多個provider-ticket時，為了不讓其中一個有過多的負載，使用負載均衡機制來平均負載
	@LoadBalanced //使用負載均衡機制
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
