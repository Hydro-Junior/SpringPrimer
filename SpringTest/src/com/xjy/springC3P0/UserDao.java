package com.xjy.springC3P0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	private JdbcTemplate jdbcTmplate;
	
	public JdbcTemplate getJdbcTmplate() {
		return jdbcTmplate;
	}

	public void setJdbcTmplate(JdbcTemplate jdbcTmplate) {
		this.jdbcTmplate = jdbcTmplate;
	}

	public void add() {
		String sql = "insert into changeseat values (?,?)";
		jdbcTmplate.update(sql,"11","kaydo");
	}

}
