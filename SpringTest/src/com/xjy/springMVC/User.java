package com.xjy.springMVC;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private String sex;
	private Integer age;
	private Address address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", sex="
				+ sex + ", age=" + age + "]";
	}
	public User(String username, String password, String email, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
	}
	
	public User(Integer id, String username, String password, String email, String sex, Integer age) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.sex = sex;
		this.age = age;
	}
	public User() {}
	
	
	
	
	
}
