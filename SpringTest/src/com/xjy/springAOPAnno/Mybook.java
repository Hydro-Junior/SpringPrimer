package com.xjy.springAOPAnno;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Mybook {
	//configure the advice by annotation
	@Before(value="execution(* com.xjy.springAOPAnno.Book.*(..))")
	public void before1() {
		System.out.println("before...");
	}
}
