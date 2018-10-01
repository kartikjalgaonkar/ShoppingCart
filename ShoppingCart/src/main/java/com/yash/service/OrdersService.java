package com.yash.service;

import com.yash.model.Orders;

public interface OrdersService {
	Orders placeOrder(Orders orders);

	Orders updateOrder(Orders orders);

	Orders getOrderDetails(int orderId);

	void deleteOrder(int orderId);
}
