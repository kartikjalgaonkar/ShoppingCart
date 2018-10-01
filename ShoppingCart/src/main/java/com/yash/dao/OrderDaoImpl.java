package com.yash.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import com.yash.model.Orders;

public class OrderDaoImpl implements OrdersDao{
	@Autowired
	EntityManager entityManager;
	
	@Override
	public Orders placeOrder(Orders orders) {
		entityManager.persist(orders);
		return orders;
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
