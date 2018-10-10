package com.yash.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.CustomerDaoImpl;
import com.yash.dao.OrderDaoImpl;
import com.yash.dao.ProductDaoImpl;
import com.yash.model.Customer;
import com.yash.model.Orders;
import com.yash.model.Product;
import com.yash.service.OrdersServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	@InjectMocks
	OrdersServiceImpl ordersServiceImpl;

	@Mock
	OrderDaoImpl orderDaoImpl;
	@Mock
	CustomerDaoImpl customerDaoImpl;
	@Mock
	ProductDaoImpl productDaoImpl;

	@Test
	public void shouldPlaceOrder() {
		Orders orders = new Orders(1, 1, 1, 10, new Date());
		when(orderDaoImpl.placeOrder(orders)).thenReturn(orders);
		Orders actualOrder = ordersServiceImpl.placeOrder(orders);
		Assert.assertEquals((Integer) 1, actualOrder.getCustomerId());
		verify(orderDaoImpl).placeOrder(orders);
	}

	@Test
	public void shouldGetOrderDetails() {
		Orders orders = new Orders(1, 1, 1, 10, new Date());
		when(orderDaoImpl.getOrderDetails(1)).thenReturn(orders);
		when(customerDaoImpl.getCustomer(1)).thenReturn(Mockito.any(Customer.class));
		when(productDaoImpl.getProduct(1)).thenReturn(Mockito.any(Product.class));

		Orders actualOrder = ordersServiceImpl.getOrderDetails(1);
		Assert.assertEquals((Integer) 1, actualOrder.getCustomerId());
		verify(orderDaoImpl).getOrderDetails(1);
	}

	@Test
	public void shouldUpdateOrder() {
		Orders orders = new Orders(1, 1, 1, 10, new Date());
		when(orderDaoImpl.updateOrder(orders)).thenReturn(orders);
		Orders actualOrder = ordersServiceImpl.updateOrder(orders);
		Assert.assertEquals((Integer) 1, actualOrder.getCustomerId());
		verify(orderDaoImpl).updateOrder(orders);

	}

	@Test
	public void shouldDeleteOrder() {
		Orders orders = new Orders(1, 1, 1, 10, new Date());
		doNothing().when(orderDaoImpl).deleteOrder(orders);
		when(orderDaoImpl.getOrderDetails(1)).thenReturn(orders);
		when(customerDaoImpl.getCustomer(1)).thenReturn(Mockito.any(Customer.class));
		when(productDaoImpl.getProduct(1)).thenReturn(Mockito.any(Product.class));
		ordersServiceImpl.deleteOrder(1);
		verify(orderDaoImpl).deleteOrder(orders);
	}

}
