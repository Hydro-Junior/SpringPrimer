package com.xjy.springTransaction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransTest {
	@Test
	public void testDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("beansTx.xml");
		OrderService service = (OrderService)context.getBean("ordersService");
		service.transFund();
	}
}
