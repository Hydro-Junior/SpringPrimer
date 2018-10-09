package com.xjy.springBean;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class User {
	public String name;
	public int age;
	public String gender;
	private String[] userArray;
	private List<String> userList;
	private Map<String,String>  userMap;
	private Properties userProperties;
	
	
	public User() {
		this.name = "defaultName";
		this.age = 1;
		this.gender = "ÄÐ";
	}
	public User(String name) {
		this.name = name;
		this.age = 1;
		this.gender = "ÄÐ";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setUserArray(String[] userArray) {
		this.userArray = userArray;
	}
	public void setUserList(List<String> userList) {
		this.userList = userList;
	}
	public void setUserMap(Map<String, String> userMap) {
		this.userMap = userMap;
	}
	public void setUserProperties(Properties userProperties) {
		this.userProperties = userProperties;
	}
	
	public void soutInfo() {
		System.out.println("arrs'length"+ userArray.length);
		System.out.println("list:"+ userList);
		System.out.println("map:"+ userMap);
		System.out.println("properties:"+userProperties);
	}
}
