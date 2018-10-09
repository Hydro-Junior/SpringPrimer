package com.xjy.springBeanAnno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="person")
@Scope(value="prototype")//multiInstance default:singleton
public class Person {
	public void add() {
		System.out.println("add...");
	}
}
