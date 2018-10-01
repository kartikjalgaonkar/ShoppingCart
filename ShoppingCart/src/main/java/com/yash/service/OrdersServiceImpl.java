package com.yash.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.yash.dao.OrderDaoImpl;
import com.yash.model.Orders;

public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrderDaoImpl ordersDaoImpl;
	
	@Override
	public Orders placeOrder(Orders orders) {
		return ordersDaoImpl.placeOrder(orders);
	}

	@Override
	public Orders updateOrder(Orders orders) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Orders getOrderDetails(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		
	}

}
