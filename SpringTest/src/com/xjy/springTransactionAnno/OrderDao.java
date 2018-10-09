package com.xjy.springTransactionAnno;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//对数据库操作的防范，不写业务操作
	public void justFund(int money, String name) {
		String sql = "update accounts set fund=fund+? where username=?";
		jdbcTemplate.update(sql,money,name);
	}
	
}
