package com.yash.test;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
		Mockito.doNothing().when(entityManager).persist(orders);
		Orders actualOrder = orderDaoImpl.placeOrder(orders);
		
		Assert.assertEquals(orders.getQuantity(), actualOrder.getQuantity());
		Mockito.verify(entityManager).persist(orders);
	}
}
