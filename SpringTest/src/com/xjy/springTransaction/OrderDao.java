package com.xjy.springTransaction;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void justFund(int money, String name) {
		String sql = "update accounts set fund=fund+? where username=?";
		jdbcTemplate.update(sql,money,name);
	}
	
}
