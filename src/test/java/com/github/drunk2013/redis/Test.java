package com.github.drunk2013.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.github.drunk2013.redis.entity.User;

public class Test {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");
		@SuppressWarnings("unchecked")
		RedisTemplate<String, User> redisTemplate = ac.getBean("redisTemplate",
				RedisTemplate.class);
		ValueOperations<String, User> valueOperations = redisTemplate
				.opsForValue();
		ListOperations<String, User> listOperations = redisTemplate.opsForList();
		User u1 = new User("drunk", 27);
		User u2 = new User("fuck", 28);
		listOperations.leftPush("user1", u1);
		valueOperations.set("user2", u2);
		System.out.println(listOperations.leftPop("user1").toString());
		System.out.println(valueOperations.get("user2").toString());
		System.out.println("end");
	}
}
