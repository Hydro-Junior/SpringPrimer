package com.xjy.springBeanAnno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xjy.springBeanAnno.UserService;

public class AnnotationTest {
	@Test
	public void testAnno() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		Person p = (Person)context.getBean("person");
		System.out.println(p);p.add();
	}
	@Test
	public void testUserService() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
		UserService service = (UserService)context.getBean("userService");
		service.add();;
		
	}
}
