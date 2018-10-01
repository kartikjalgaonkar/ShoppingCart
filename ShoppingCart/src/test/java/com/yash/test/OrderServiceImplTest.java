package com.yash.test;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.OrderDaoImpl;
import com.yash.model.Orders;
import com.yash.service.OrdersServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest {

	@InjectMocks
	OrdersServiceImpl ordersServiceImpl;
	
	@Mock
	OrderDaoImpl orderDaoImpl;
	
	@Test
	public void shouldPlaceOrder(){
		Orders orders= new Orders(1, 1, 1, 10, new Date());
		Mockito.when(orderDaoImpl.placeOrder(orders)).thenReturn(orders);
		Orders actualOrder = ordersServiceImpl.placeOrder(orders);
		Assert.assertEquals((Integer)1, actualOrder.getCustomerId());
		Mockito.verify(orderDaoImpl).placeOrder(orders);
	}
	
	
}
