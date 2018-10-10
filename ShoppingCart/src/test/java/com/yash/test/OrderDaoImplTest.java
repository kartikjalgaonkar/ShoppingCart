package com.yash.test;

import java.util.Date;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.OrderDaoImpl;
import com.yash.model.Orders;

@RunWith(MockitoJUnitRunner.class)
public class OrderDaoImplTest {
	
	@InjectMocks
	OrderDaoImpl orderDaoImpl;
	
	@Mock
	EntityManager entityManager;
	
	
	@Test
	public void shouldPlaceOrder(){
		Orders orders = new Orders(2, 1, 1, 5, new Date());
		doNothing().when(entityManager).persist(orders);
		Orders actualOrder = orderDaoImpl.placeOrder(orders);
		
		assertEquals((Integer)5, actualOrder.getQuantity());
		verify(entityManager).persist(orders);
	}
	
	@Test
	public void shouldUpdateOrder(){
		Orders orders = new Orders(2, 1, 1, 5, new Date());
		when(entityManager.merge(orders)).thenReturn(orders);
		Orders actualOrder = orderDaoImpl.updateOrder(orders);
		assertEquals((Integer)5, orders.getQuantity());
		verify(entityManager).merge(orders);
	}
	
	@Test
	public void shouldGetOrder(){
		Orders orders = new Orders(2, 1, 1, 5, new Date());
		when(entityManager.find(Orders.class, 1)).thenReturn(orders);
		Orders actualOrder = orderDaoImpl.getOrderDetails(1);
		assertEquals((Integer)5, actualOrder.getQuantity());
		verify(entityManager).find(Orders.class, 1);
	}
	
	@Test
	public void shouldDeleteOrder(){
		Orders orders = new Orders(2, 1, 1, 5, new Date());
		doNothing().when(entityManager).remove(orders);
		orderDaoImpl.deleteOrder(orders);
		verify(entityManager).remove(orders);
	}
}
