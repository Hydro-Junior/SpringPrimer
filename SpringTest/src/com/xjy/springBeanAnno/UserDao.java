package com.xjy.springBeanAnno;

import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDao {
	public void add() {
		System.out.println("Dao add...");
	}
}
