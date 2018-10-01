package com.yash.test;

import javax.persistence.EntityManager;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.any;

import static org.mockito.Mockito.doNothing;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.ProductDaoImpl;
import com.yash.model.Customer;
import com.yash.model.Product;
import com.yash.service.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class ProductDaoImplTest {

	@InjectMocks
	ProductDaoImpl productDaoImpl;

	@Mock
	EntityManager entityManager;

	@Test
	public void shouldAddProduct() {

		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Mobile");
		product.setPrice(5000);
		
		doNothing().when(entityManager).persist(product);
		Product actual = productDaoImpl.addProduct(product);

		assertEquals(actual.getProductId(), actual.getProductId());
		Mockito.verify(entityManager).persist(product);
	}
	
	@Test
	public void shouldGetProduct(){
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Mobile");
		product.setPrice(5000);
		
		Mockito.when(entityManager.find(Product.class, 1)).thenReturn(product);
		Product actual = productDaoImpl.getProduct(1);
		
		assertEquals("Mobile", actual.getProductName());
		Mockito.verify(entityManager).find(Product.class, 1);
		
	}
	
	@Test
	public void shouldUpdateCustomer(){
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Mobile Device");
		product.setPrice(5000);
		
		Mockito.when(entityManager.merge(product)).thenReturn(product);
		Product actual = productDaoImpl.updateProduct(product);
		
		assertEquals("Mobile Device", actual.getProductName());
		Mockito.verify(entityManager).merge(product);
	}
	
	@Test
	public void shouldDeleteCustomer(){
		Product product = new Product();
		product.setProductId(1);
		product.setProductName("Mobile Device");
		product.setPrice(5000);
		
		doNothing().when(entityManager).remove(product);
		 productDaoImpl.deleteProduct(product);
		
		Mockito.verify(entityManager).remove(product);
	}
}
