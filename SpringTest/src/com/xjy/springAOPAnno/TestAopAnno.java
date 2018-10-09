package com.xjy.springAOPAnno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAopAnno {
	@Test
	public void testDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans4aop.xml");
		Book book = (Book)context.getBean("book");
		book.add();
	}
}
