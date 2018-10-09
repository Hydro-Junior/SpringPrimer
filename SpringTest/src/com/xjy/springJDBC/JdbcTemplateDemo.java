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
 * ��������ּ����ϤSpringJdbc��һЩģ�������ûʲô����ĺ������ǵõ������ݿ�������
 * "jdbc:mysql://127.0.0.1:3306/sensormng?useSSL=false&useUnicode=true&characterEncoding=utf-8";
 * 
 */
public class JdbcTemplateDemo {
	private static DriverManagerDataSource dataSource = null;
	private static JdbcTemplate jdbcTemplate = null;
	
	/*static {
		//1.���������������ݿ���Ϣ
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///mytest");
		dataSource.setUsername("root");
		dataSource.setPassword("xjy123");
		//2.����JDBCTemplate������������Դ
		jdbcTemplate = new JdbcTemplate(dataSource);
	}*/
	@Test//���
	public void add() {
		//3.����JdbcTemplate��ķ���ʵ�ֲ���
		String sql = "insert into changeseat (student) values (?)";
		int rows = jdbcTemplate.update(sql,"testSpringJdbc");
		System.out.println(rows);
	}
	@Test//�޸�
	public void modify() {
		String sql = "update changeseat set student=? where id > ?";
		int rows = jdbcTemplate.update(sql,"���",16);
		System.out.println(rows);
	}
	@Test//ɾ��
	public void delete() {
		String sql = "delete from changeseat where student=?";
		int rows = jdbcTemplate.update(sql,"testSpringJdbc");
		System.out.println(rows);
	}
	
	//��ѯ���ص� ��    
	@Test //1.����һ��ֵ
	public void queryCount() {
		String sql = "select count(*) from employee";
		int rowCount = jdbcTemplate.queryForObject(sql,Integer.class);
		System.out.println(rowCount);
	}
	@Test //2.����һ������ (�Լ�д��̳�rowMapperʵ�����ݷ�װ)
	public void queryEmployee() {
		String sql = "select * from employee where name = ?";
		Employee emp = jdbcTemplate.queryForObject(sql,new MyRowMapper(),"delta");
		System.out.println(emp);
	}
	@Test //3.����list����
	public void queryList() {
		String sql = "select * from employee";
		List<Employee> ls = jdbcTemplate.query(sql, new MyRowMapper());
		System.out.println(ls);
	}
	
	@Test //C3P0���ӳ�ʹ��(д��������)
	public void testC3P0() {
		//ComboPooledDataSource dataSource = new ComboPooledDataSource();
	}
	
	@Test //·����λ����
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
//��ѯ��Ҫ�õ��Ľӿ�
class MyRowMapper implements RowMapper<Employee>{
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// 1.�ӽ�����еõ�����
		String name = rs.getString("name");
		int salary = rs.getInt("salary");
		int id = rs.getInt("id");
		// 2.��װ���ݵ�����
		Employee emp = new Employee();
		emp.setName(name);
		emp.setId(id);
		emp.setSalary(salary);
		return emp;
	}
	
}