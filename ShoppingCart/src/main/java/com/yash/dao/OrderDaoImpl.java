package com.yash.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yash.model.Orders;

@Repository
public class OrderDaoImpl implements OrdersDao{
	@Autowired
	EntityManager entityManager;
	
	@Override
	@Transactional
	public Orders placeOrder(Orders orders) {
		entityManager.persist(orders);
		return orders;
	}

	@Override
	@Transactional
	public Orders updateOrder(Orders orders) {
		entityManager.merge(orders);
		return orders;
	}

	@Override
	@Transactional
	public Orders getOrderDetails(int orderId) {
		return entityManager.find(Orders.class, orderId);
		
	}

	@Override
	@Transactional
	public void deleteOrder(Orders orders) {
		entityManager.remove(orders);
		
	}

}
