package com.xjy.springTransactionAnno;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransTest {
	@Test
	public void testDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beansTxAnno.xml");
		OrderService service = (OrderService)context.getBean("ordersService");
		service.transFund();
	}
}
