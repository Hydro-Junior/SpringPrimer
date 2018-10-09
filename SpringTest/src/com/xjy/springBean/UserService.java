package com.xjy.springBean;

public class UserService {
	private UserDao dao ;
	public UserDao getDao() {
		return dao;
	}
	public void setDao(UserDao dao) {
		this.dao = dao;
	}
	public void add() {
		System.out.println("service...");
		dao.add();
		/*UserDao dao = new UserDao();
		dao.add();*/
	}
}
