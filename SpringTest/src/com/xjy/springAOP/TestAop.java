package com.xjy.springAOP;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {
	@Test
	public void testAdd() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans3aop.xml");
		Book book = (Book)context.getBean("book");
		book.add();
	}
}
