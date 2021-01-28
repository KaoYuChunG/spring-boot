package com.kao.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//ES有兩種實現方式
//1.jest，需要引入包才可以調用。主要適用於跟html互動的
//2.springdata ES:(默認)  要注意版本entre spring data e elasticsearch。參考springdata 官網
//       -> 安裝elasticsearch對應版本(better)或升級springboot
//  client 節點信息 clusterNodes, clusterName
//  ElasticsearchTemplate 進行操作
//  編寫一個ElasticsearchRepository的接口來操作
@SpringBootApplication
public class ElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

}
