package com.xjy.springTransactionAnno;

import org.springframework.transaction.annotation.Transactional;

//业务逻辑层
@Transactional
public class OrderService {
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public void transFund() {
		//Jack少一千
		orderDao.justFund(-1000, "Jack");
		//异常
		int i=1/0;
		//Mary多一千
		orderDao.justFund(1000, "Mary");
	}
}
