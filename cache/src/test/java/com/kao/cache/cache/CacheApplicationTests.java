package com.kao.cache.cache;

import com.kao.cache.cache.bean.Employee;
import com.kao.cache.cache.mapper.IEmployeeMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class CacheApplicationTests {

	@Autowired
	IEmployeeMapper employeeMapper;

//	一但配置好redis　就可以因引用StringRedisTemplate和RedisTemplate
	@Autowired
	StringRedisTemplate stringRedisTemplate;//針對string使用的

	@Autowired
	RedisTemplate redisTemplate;//針對對象的

	@Autowired
	RedisTemplate<Object, Employee> empRedisTemplate;

//	StringRedisTemplate　有一些方法來處理
//	opsForValue ->　string
//	opsForList -> list
//	opsForSet -> Set 集合
//	opsForHash -> hash 散列
//	opsForZSet -> ZSet 有序集合

//	leftPush 這是redis 的命令指令，官網有的命令都可以使用。
	@Test
	public void stringRedis() {
		stringRedisTemplate.opsForValue().append("msg","hello");
		String msg = stringRedisTemplate.opsForValue().get("msg");

		stringRedisTemplate.opsForList().leftPush("mylist", "1");
		stringRedisTemplate.opsForList().leftPush("mylist", "2");
		stringRedisTemplate.opsForList().leftPush("mylist", "3");
	}

	@Test
	public void objectRedis() {
//		默認的序列化器是JDK
		Employee emp = employeeMapper.getEmpById(1);
//		redisTemplate.opsForValue().set("emp-01",emp);
//		將數據轉為json保存以便閱讀，此為用Bean自定義的RedisTemplate
		empRedisTemplate.opsForValue().set("emp-01",emp);
	}

	@Test
	void contextLoads() {
		Employee employee = employeeMapper.getEmpById(1);
		System.out.println(employee);
	}

}
