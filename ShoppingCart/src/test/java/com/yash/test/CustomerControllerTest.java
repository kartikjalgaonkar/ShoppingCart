package com.yash.test;

import org.aspectj.lang.annotation.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.yash.controller.CustomerController;
import com.yash.dao.CustomerDaoImpl;
import com.yash.model.Customer;
import com.yash.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value=CustomerController.class, secure=false)
@Ignore
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	CustomerController customerController;
	
	@MockBean
	CustomerServiceImpl customerServiceImpl;
	
	@org.junit.Before
	public void setUp(){
		this.mockMvc=MockMvcBuilders.standaloneSetup(customerController).build();
	}
	
	@Test
	public void shouldAddCustomer() throws Exception{
		
		
		Customer customer = new Customer();
		customer.setCustomerId(1);
		customer.setCustomerName("kartik");
		customer.setContactNumber(45645645l);
		
		Mockito.when(customerServiceImpl.addCustomer(Mockito.any(Customer.class))).thenReturn(customer);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/customers").accept(MediaType.APPLICATION_JSON_VALUE);
		System.out.println("hi1");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(mvcResult.getResponse());
		
		String expected = "{customerName:kartik,address:pusad,contactNumber:45645645}";
		
		JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
	}
}
