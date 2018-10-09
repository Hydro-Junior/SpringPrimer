package com.xjy.springMVC;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Mr.Xu RequestMapping的value method params heads 分别表示 请求URL 请求方法 请求参数
 *         请求头
 */
@SessionAttributes({"user"})//默认是value，也可以规定类型@SessionAttributes(value={"user"},types={String.class})
@Controller
@RequestMapping("springmvc") // 相对于web应用的跟目录
public class SpringMVCTest {
	private static final String SUCCESS = "success";

	@RequestMapping("/testRequestMapping")
	public String testRequestMapping() {
		System.out.println("testRequestMapping");
		return SUCCESS;
	}

	// 响应post请求
	@RequestMapping(value = "/testMethod", method = RequestMethod.POST)
	public String testMethod() {
		System.out.println("testMethod");
		return SUCCESS;
	}

	// 限制参数(这里请求头限制语言用谷歌有效,用eclipse自带的浏览器不行),更精确地映射请求
	@RequestMapping(value = "/testParamsAndHeaders", params = {"username", "age!=0" }, headers = {
			"Accept-Language=zh-CN,zh;q=0.9" })
	public String testParamsAndHeaders() {
		System.out.println("testParamsAndHeaders");
		return SUCCESS;
	}

	// 重点：利用PathVariable，将URL中的占位符映射到参数
	// 接近Rest风格的里程碑
	@RequestMapping("/testPathVariable/{id}")
	public String testPathVariable(@PathVariable(value = "id") Integer id) {// value默认属性可不写
		System.out.println("testPathVariable: " + id);
		return SUCCESS;
	}

	/**
	 * *******************************************************************************************
	 */
	// 接下来四个方法测试Rest中的请求转换,注意这里针对delete,put等方法不能实现页面跳转，尝试用ResponseBody注解，将数据直接写入响应体中
	// 发送put请求和delete请求的方式：配置HiddenHttpMethodFilter,在发送Post请求时携带一个隐藏域 name="_method",值为DELETE或	PUT
	// 1.GET
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
	public String testRest(@PathVariable Integer id) {
		System.out.println("testRest GET:" + id);
		return SUCCESS;
	}

	// 2.POST
	@RequestMapping(value = "/testRest", method = RequestMethod.POST)
	public String testRest() {
		System.out.println("testRest POST:");
		return SUCCESS;
	}

	// 3.DELETE
	@ResponseBody
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
	public String testRestDelete(@PathVariable Integer id) {
		System.out.println("testRest Delete:" + id);
		return SUCCESS;
	}

	// 4.PUT
	@ResponseBody
	@RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
	public String testRestPut(@PathVariable Integer id) {
		System.out.println("testRest Put:" + id);
		return SUCCESS;
	}
	/**
	 ***********************************************************************************
	 */
	// 普通请求参数应对
	@RequestMapping(value="/testRequestParam")
	public String testRequestParam(@RequestParam(value="username",defaultValue="Jack")String un,@RequestParam(value="age",required=false) Integer age) {
		System.out.println("testRequestParam,username：" + un+"	,age:" + age);
		return SUCCESS;
	}
	// 请求头
	@RequestMapping("testRequestHeader")
	public String testRequestHeader(@RequestHeader(value="Accept-Language")String al) {
		System.out.println("testRequestHeader: Accept-Language "+ al);
		return SUCCESS;
	}
	// Cookies
	@RequestMapping("testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
		System.out.println("testCookieValue: sessionId" + sessionId);
		return SUCCESS;
	}
	//提交表单-->使用POJO对象作为参数，MVC完成请求参数名和对象属性值自动映射（还支持级联属性）
	@RequestMapping("testPojo")
	public String testPojo(User user) {
		System.out.println("testPojo:" + "name: " +user.getUsername()+" e-mail:" + user.getEmail() +" gender:"+ user.getSex()+
				"city:"+user.getAddress().getCity());
		return SUCCESS;
	}
	
	//Servlet原始API的支持
	@RequestMapping("testServletAPI")
	public String testServletAPI(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("testServletAPI:" + request + "," + response);
		return SUCCESS;
	}
	/**
	 * Spring MVC 处理模型数据的几种方法：
	 * 1. ModelAndView （处理方法返回值类型为ModelAndView时，方法体即可通过该对象添加模型数据）
	 * 2. Map及Model（入参为Model、ModelMap、Map时，Map中的数据会自动添加到模型中）
	 * 3. @SessionAttributes(将模型中的某个属性暂存到HttpSession中)
	 * 4. @ModelAttribute（放到数据模型中）
	 */
	
	@RequestMapping("testModelAndView")
	public ModelAndView testModelAndView() {
		String viewName = SUCCESS;
		ModelAndView modelAndView = new ModelAndView(viewName);
		//添加模型数据到ModelAndView中
		modelAndView.addObject("time", new Date());
		return modelAndView;
	}
	@RequestMapping("testMap")
	public String testMap(Map<String,Object> map) {
		map.put("names", Arrays.asList("Tom","Jerry","Mike"));
		return SUCCESS;
	}
	//@SessionAttributes(在类上注解，一般为控制器) 实现多个请求间共用某个模型属性数据
	@RequestMapping("testSessionAttributes")
	public String testSessionAttributes(Map<String,Object> map) {
		User user = new User("Jack","123333","9978@123.com","男");
		map.put("user", user);
		return SUCCESS;
	}
	/**
	 * 通过提交表单修改数据库中某些字段的值
	 */
	@RequestMapping("testModelAttribute")//注意WebDataBinder和implicitModel（预先查找隐式模型，有则更新，无则反射，然后存到request域对象中）的作用
	public String testModelAttribute(@ModelAttribute("user") User user) {//注意这里的user也会被自动写到request域中
		System.out.println("修改后：" + user);
		return SUCCESS;
	}
	@ModelAttribute//模拟被修改的对象
	public void getUser(@RequestParam(value="id",required=false) Integer id,Map<String,Object> map) {
		if(id != null) {//模拟：隐藏域中的id不为空，说明这个条目在数据库中有记录
			User user = new User(1,"Jack","123","ja@123.com","男",12);
			System.out.println("从数据库中获取的对象:" + user);
			map.put("user", user);
		}
	}
	
	
}
