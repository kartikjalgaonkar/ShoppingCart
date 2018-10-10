package com.yash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yash.dao.CustomerDaoImpl;
import com.yash.dao.OrderDaoImpl;
import com.yash.dao.ProductDaoImpl;
import com.yash.model.Orders;

@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	OrderDaoImpl ordersDaoImpl;
	@Autowired
	CustomerDaoImpl customerDaoImpl;
	@Autowired
	ProductDaoImpl productDaoImpl;
	
	@Override
	public Orders placeOrder(Orders orders) {
		return ordersDaoImpl.placeOrder(orders);
	}

	@Override
	public Orders updateOrder(Orders orders) {
		return ordersDaoImpl.updateOrder(orders);
	}

	@Override
	public Orders getOrderDetails(int orderId) {
		
		Orders order = ordersDaoImpl.getOrderDetails(orderId);
		order.setCustomer(customerDaoImpl.getCustomer(order.getCustomerId()));
		order.setProduct(productDaoImpl.getProduct(order.getProductId()));
		return order;
	}

	@Override
	public void deleteOrder(int orderId) {
		Orders orders = getOrderDetails(orderId);
		ordersDaoImpl.deleteOrder(orders);
		
	}

}
