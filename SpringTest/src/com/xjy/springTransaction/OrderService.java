package com.xjy.springTransaction;
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void transFund() {

		orderDao.justFund(-1000, "Jack");
		
		orderDao.justFund(1000, "Mary");
	}
}
