package com.xjy.springAOP;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author Mr.Xu
 * Class for advice,using "excution" to config the point cut
 * 
 */
public class MyBook {
	//before advice
	public void before1() {
		System.out.println("before advice...");
	}
	//after advice
	public void after1() {
		System.out.println("after advice...");
	}
	//proceedingJoinPoint -->complete methodInterceptor
	public void around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("before the method...");
		
		proceedingJoinPoint.proceed();
		
		System.out.println("after the method...");
	}
}
