package com.kao.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//只要加入devtools 在pom文件就立馬啟動熱部屬模式
//使用其模式可以方便於如果有修改，佈用重啟 ctrl + F9 就好了 相當於 build 命令
@SpringBootApplication
public class DeployApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeployApplication.class, args);
	}

}
