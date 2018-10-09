package com.xjy.springJDBC;

import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author Mr.Xu
 * 创建此类旨在熟悉SpringJdbc的一些模板操作，没什么很深的含量（记得导入数据库驱动）
 * "jdbc:mysql://127.0.0.1:3306/sensormng?useSSL=false&useUnicode=true&characterEncoding=utf-8";
 * 
 */
public class JdbcTemplateDemo {
	private static DriverManagerDataSource dataSource = null;
	private static JdbcTemplate jdbcTemplate = null;
	
	/*static {
		//1.创建对象，设置数据库信息
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mytest");
		dataSource.setUsername("root");
		dataSource.setPassword("xjy123");
		//2.创建JDBCTemplate对象，设置数据源
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	@Test//添加
	public void add() {
		//3.调用JdbcTemplate里的方法实现操作
		String sql = "insert into changeseat (student) values (?)";
		int rows = jdbcTemplate.update(sql,"testSpringJdbc");
		System.out.println(rows);
	}
	@Test//修改
	public void modify() {
		String sql = "update changeseat set student=? where id > ?";
		int rows = jdbcTemplate.update(sql,"万古",16);
		System.out.println(rows);
	}
	@Test//删除
	public void delete() {
		String sql = "delete from changeseat where student=?";
		int rows = jdbcTemplate.update(sql,"testSpringJdbc");
		System.out.println(rows);
	}
	
	//查询（重点 ）    
	@Test //1.返回一个值
	public void queryCount() {
		String sql = "select count(*) from employee";
		int rowCount = jdbcTemplate.queryForObject(sql,Integer.class);
		System.out.println(rowCount);
	}
	@Test //2.返回一个对象 (自己写类继承rowMapper实现数据封装)
	public void queryEmployee() {
		String sql = "select * from employee where name = ?";
		Employee emp = jdbcTemplate.queryForObject(sql,new MyRowMapper(),"delta");
		System.out.println(emp);
	}
	@Test //3.返回list集合
	public void queryList() {
		String sql = "select * from employee";
		List<Employee> ls = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(ls);
	}
	
	@Test //C3P0连接池使用(写到其他包)
	public void testC3P0() {
		//ComboPooledDataSource dataSource = new ComboPooledDataSource();
	}
	
	@Test //路径定位测试
	public void testPath() {
		Properties p = new Properties();
		try {
			String path = this.getClass().getResource("/").getPath();
			path = path.substring(1, path.indexOf("classes"));
			System.out.println(path);
			p.load(new FileInputStream(path+"conf/globalConf.properties"));
			
			System.out.println("my name is :" + p.getProperty("name"));
		}catch (Exception e) {
		}
		
	}
	
}
//查询需要用到的接口
class MyRowMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 1.从结果集中得到数据
		String name = rs.getString("name");
		int salary = rs.getInt("salary");
		int id = rs.getInt("id");
		// 2.封装数据到对象
		Employee emp = new Employee();
		emp.setName(name);
		emp.setId(id);
		emp.setSalary(salary);
		return emp;
	}
	
}