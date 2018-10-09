package com.xjy.springMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Controller
public class MvcHelloWorld {
	/**
	 * 1. 使用@RequestMapping注解映射请求的URL
	 * 2. 返回值通过视图解析器解析为实际的物理视图，对于InternalResourceViewResolver
	 *    通过prefix + returnVal + suffix 这样的方式得到实际的物理视图，然后做转发操作
	 * 
	 * /WEB-INF/views/success.jsp(详见配置文件)
	 * @return
	 */
	@RequestMapping("/helloWorld")
	public String hello() {
		System.out.println("hello world!");
		return "success";
	}
}
