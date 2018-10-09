package com.xjy.springBeanAnno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value="userService")
public class UserService {
	@Autowired
	private UserDao dao ;//��resource����name=valueOfObjectע��ʵ��
	public UserDao getDao() {
		return dao;
	}
	/*public void setDao(UserDao dao) {
		this.dao = dao;
	}*/ 
	public void add() {
		System.out.println("service...");
		dao.add();
		/*UserDao dao = new UserDao();
		dao.add();*/
	}
}
