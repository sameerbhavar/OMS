package com.oms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oms.model.Customer;
import com.oms.model.Orders;
import com.oms.service.CustomerService;
import com.oms.service.OrderService;

@SpringBootTest
class OmsApplicationTests {
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {
	}
	
	@Test
    public void testCreateCustomer() {
		
        Customer customer = new Customer();
        customer.setName("Sammer Bhavar");
        customer.setEmail("sammer@example.com");
        Customer createdCustomer = customerService.createCustomer(customer);
        assertNotNull(createdCustomer.getCustomerId());
    }
	
	@Test
    public void testCreateOrder() {
        Orders order = new Orders();
        order.setTotalCost(100.0);
        Customer customer = new Customer();
        customer.setName("Sammer Bhavar");
        customer.setEmail("sammer@example.com");
        customer = customerService.createCustomer(customer);

		order.setCustomer(customer);
		Orders createdOrder = orderService.createOrder(order, customer);
		assertNotNull(createdOrder.getOrdersId());
		assertEquals(customer.getCustomerId(), createdOrder.getCustomer().getCustomerId());
		// Check if the appropriate discount is applied based on the customer's tier
		assertEquals(90.0, createdOrder.getDiscount(), 0.01); // 10% discount for gold
		
		
		}
	

}
