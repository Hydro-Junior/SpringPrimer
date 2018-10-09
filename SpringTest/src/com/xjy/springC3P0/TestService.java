package com.xjy.springC3P0;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestService {
	@Test
	public void testDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beanC3P0.xml");
		UserService service = (UserService)context.getBean("userService");
		service.add();
	}
}
