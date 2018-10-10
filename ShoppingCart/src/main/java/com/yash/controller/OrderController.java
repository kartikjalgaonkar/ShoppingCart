package com.yash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Orders;
import com.yash.service.OrdersServiceImpl;

@RestController
public class OrderController {

	@Autowired
	OrdersServiceImpl oderServiceImpl;
	
	@PostMapping(value="/orders", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Orders addOrder(@RequestBody Orders orders){
		return oderServiceImpl.placeOrder(orders);
	}
	
	@GetMapping(value="/orders/{orderId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Orders getOrder(@PathVariable int orderId){
		return oderServiceImpl.getOrderDetails(orderId);
	}
	
	@PutMapping(value="/orders",consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Orders updateOrders(@RequestBody Orders orders){
		return oderServiceImpl.updateOrder(orders);
	}
	
	@DeleteMapping(value="/orders/{orderId}")
	public void deleteOrders(@PathVariable int orderId){
		oderServiceImpl.deleteOrder(orderId);
	}
}
