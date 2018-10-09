package com.xjy.springTransactionAnno;

import org.springframework.transaction.annotation.Transactional;

//ҵ���߼���
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void transFund() {
		//Jack��һǧ
		orderDao.justFund(-1000, "Jack");
		//�쳣
		int i=1/0;
		//Mary��һǧ
		orderDao.justFund(1000, "Mary");
	}
}
