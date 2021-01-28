package com.kao.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//自定義健康狀態指示器
//1.編寫一個指示器實現healthIndicator接口
//2.指示器(class)名子 xxxhhealthIndicator
//3.加入容器中
@SpringBootApplication
public class ActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuatorApplication.class, args);
	}

}
