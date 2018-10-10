package com.yash.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.yash.dao.ProductDaoImpl;
import com.yash.model.Product;
import com.yash.service.ProductServiceImpl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceImplTest {
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductDaoImpl productDaoImpl;
	
	@Test
	public void shouldAddProduct(){
		Product product= new Product(1, "fridge", 10000);
		when(productDaoImpl.addProduct(product)).thenReturn(product);
		Product actualProduct = productServiceImpl.addProduct(product);
		assertEquals((Integer)1, actualProduct.getProductId());
		verify(productDaoImpl).addProduct(product);
	}
	
	@Test
	public void shouldGetProduct(){
		Product product= new Product(1, "fridge", 10000);
		when(productDaoImpl.getProduct(1)).thenReturn(product);
		Product actualProduct = productServiceImpl.getProduct(1);
		assertEquals((Integer)1, actualProduct.getProductId());
		verify(productDaoImpl).getProduct(1);
	}
	
	@Test
	public void shouldUpdateProduct(){
		Product product= new Product(1, "fridge", 10000);
		when(productDaoImpl.updateProduct(product)).thenReturn(product);
		Product actualProduct = productServiceImpl.updateProduct(product);
		assertEquals((Integer)1, actualProduct.getProductId());
		verify(productDaoImpl).updateProduct(actualProduct);
	}
	
	@Test
	public void shouldDeleteProduct(){
		Product product= new Product(1, "fridge", 10000);
		when(productDaoImpl.getProduct(1)).thenReturn(product);
		doNothing().when(productDaoImpl).deleteProduct(product);
		productServiceImpl.deleteProduct(1);
		verify(productDaoImpl).getProduct(1);
		verify(productDaoImpl).deleteProduct(product);
		
	}

}
