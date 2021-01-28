package com.kao.cache.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

//configure environment
//1.create table deparment and employee
//2.create beans deparment and employee
//3.add library myBatis:
// 		configure font no properties.
//		use notification of mybatis：@MapperScan to package where mapper interface is on
//		replace XXmapper.xml

//test cache
//1.open the base notification of cache
//2.notifica cache is ok: @Cacheable, @CacheEvice, @CachePut

//redis
//1.install redis by docker
//2.add starter of redis
//3.configure redis no properties
@MapperScan("com.kao.cache.cache.mapper")
@SpringBootApplication
@EnableCaching
public class CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(CacheApplication.class, args);
	}

}
