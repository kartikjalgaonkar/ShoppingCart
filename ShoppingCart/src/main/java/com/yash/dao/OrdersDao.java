package com.yash.dao;

import com.yash.model.Orders;

public interface OrdersDao {
	Orders placeOrder(Orders orders);

	Orders updateOrder(Orders orders);

	Orders getOrderDetails(int orderId);

	void deleteOrder(Orders orders);
}
