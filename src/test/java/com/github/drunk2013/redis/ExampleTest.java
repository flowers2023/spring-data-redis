package com.github.drunk2013.redis;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.drunk2013.redis.entity.User;


@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class ExampleTest {
	/**
	 * ValueOperations<K, V>	简单K-V操作
	 * SetOperations<K, V>		set类型数据操作
	 * ZSetOperations<K, V>		zset类型的数据操作
	 * HashOperations<H, HK, HV>针对MAP类型的数据操作
	 * ListOperations<K, V>		针对list类型的数据操作
	 */
	@Autowired
	RedisTemplate<String, User> redisTemplate;
	@Resource(name="redisTemplate")
	ValueOperations<String, User> valueOperations;
	@Resource(name="redisTemplate")
	ListOperations<String, User> listOperations;
	
	
	@Before
	public void setUpBeforeClass() throws Exception {

	}

	@Test
	public void baseTest() {
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
	
	@Test
	public void autoTest() {

		User u1 = new User("drunk", 88);
		User u2 = new User("fuck", 89);
		listOperations.leftPush("user3", u1);
		valueOperations.set("user4", u2);
		System.out.println(listOperations.leftPop("user3").toString());
		System.out.println(valueOperations.get("user4").toString());
		System.out.println("end");
	}

}
