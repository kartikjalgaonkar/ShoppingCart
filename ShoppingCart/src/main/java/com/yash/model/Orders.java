package com.yash.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	private Integer customerId;
	private Integer productId;
	
	@Transient
	private Customer customer;
	@Transient
	private Product product;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	private Integer quantity;
	private Date orderDate;



	public Orders(Integer orderId, Integer customerId, Integer productId, Integer quantity, Date orderDate) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
		this.orderDate = orderDate;
	}

	

	public Integer getCustomerId() {
		return customerId;
	}

	

	public Integer getProductId() {
		return productId;
	}

	

	public Integer getQuantity() {
		return quantity;
	}

	

}
