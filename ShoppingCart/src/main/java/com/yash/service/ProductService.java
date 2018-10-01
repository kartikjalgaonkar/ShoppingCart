package com.yash.service;


import com.yash.model.Product;

public interface ProductService {

	Product addProduct(Product product);
	Product updateProduct(Product product);
	Product getProduct(int productId);
	void deleteProduct(int productId);
	
}
