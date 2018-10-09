package com.xjy.springBean;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCTest {
	@Test
	public void testUser() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		User user = (User)context.getBean("user");
		User user2 = (User)context.getBean("user");
		user.soutInfo();
		System.out.println(user2.name);
	}
	
	@Test
	public void testUserService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans1.xml");
		UserService service = (UserService)context.getBean("userService");
		service.add();;
		
	}
}
