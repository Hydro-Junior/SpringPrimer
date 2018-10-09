<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 超链接路径开头慎写斜杠 -->
	<!---------------------------------modify Object----------------------------------------------------------------------->
	<!-- 模拟修改数据操作(这里就不用数据库了)
		1. 原始数据为1,Jack,123,22@123.com,男,age
		2. 要求密码不能被修改
		3. 表单回显，模拟操作直接在表单填写对应的属性值
	 -->
	<form action="springmvc/testModelAttribute" method="Post">
		<input type="hidden" name="id" value="1"/>
		username:<input type="text" name="username" value="Jack"/><br>
		email:<input type="text" name="email" value="ja@123.com"/><br>
		sex:<input type="text" name="sex" value="男"/><br>
		age:<input type="text" name="age" value="13"/><br>
		<input type="submit" value="submit">
	</form>
	<!---------------------------------Test ModelAndView----------------------------------------------------------------------->
	<a href="springmvc/testModelAndView">Test ModelAndView</a>&nbsp&nbsp
	<a href="springmvc/testMap">Test Map</a>&nbsp&nbsp
	<a href="springmvc/testSessionAttributes">Test SessionAttribute</a><br>
	<!---------------------------------Test ServletAPI----------------------------------------------------------------------->
	<a href="springmvc/testServletAPI">Test SpringAPI</a>
    <br><br>
	<!--------------------------------Test POJO Mapping Form------------------------------------------------------------------>
	<form action="springmvc/testPojo" method="post">
		<B>UserName</B>: <input type="text" name="username"/>
		<br>
		<B>PassWord</B>: <input type="password" name="password"/>
		<br>
		<B>email</B>: <input type="text" name="email">
		<br>
		<B>sex</B>: &nbsp&nbsp boy<input type="radio" name="sex" value="男">
					&nbsp&nbsp girl<input type="radio" name="sex" value="女"><br>
		<B>age</B>: <input type="text" name="age"><br>
		<B>province</B>: <input type="text" name="address.province"><br>
		<B>city</B>: <input type="text" name="address.city">
		<br>
		<input type="submit" value="Submit">
	</form><br><br>
	<!----------------------------Test Parameters,Headers,Cookies---------------------------------------------------------------------->
	<a href="springmvc/testRequestParam?username=xjy&age=18">Test RequestParam</a><br><br>
	<a href="springmvc/testRequestHeader">Test RequestHeader</a><br><br>
    <a href="springmvc/testCookieValue">Test CookieValue</a><br><br>
	<!----------------------------Test Rest------------------------------------------------------------->
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="PUT"><!-- 请求转换，利用了隐藏域 和 hiddenHttpMethodFilter-->
		<input type="submit" value="TestRest PUT">
	</form>
	<br><br>
	<form action="springmvc/testRest/1" method="post">
		<input type="hidden" name="_method" value="DELETE">
		<input type="submit" value="TestRest DELETE">
	</form>
	<br><br>
	<form action="springmvc/testRest" method="post">
		<input type="submit" value="TestRest POST">
	</form>
	<br><br>
	<a href="springmvc/testRest/1">Test Rest Get</a>
	<br><br>
	<!----------------------------Basic Test------------------------------------------------------------->
	<a href="springmvc/testPathVariable/3">Test PathVariable</a><br><br>
	<a href="springmvc/testParamsAndHeaders?username=xjy&age=10">Test ParamsAndHeaders</a><br><br>
		Test Method<br>
	<form action="springmvc/testMethod" method="POST">
		<input type="submit" value="submit">
	</form><br><br>
	
	<a href="springmvc/testRequestMapping">Test RequestMapping</a><br><br>
	<a href="helloWorld">Hello World</a>
</body>
</html>