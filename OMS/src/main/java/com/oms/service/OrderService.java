package com.oms.service;

import com.oms.model.Customer;
import com.oms.model.Orders;
import com.oms.repo.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
	
	@Autowired
    OrdersRepo ordersRepo;

		@Async
	    public Orders createOrder(Orders order, Customer customer) {

		 Integer existingOrderNumber = customer.getOrderCount();

		 existingOrderNumber++;

		 customer.setOrderCount(existingOrderNumber);

		 customer.updateCustomerTier();

		 if(customer.getCustomerType().equals("gold")) {

			 order.setDiscount(10.00);

		 }else if(customer.getCustomerType().equals("platinum")) {

			 order.setDiscount(20.00);

		 }else {

			 order.setDiscount(0.00);

		 }
		 
		 customer.getAllOrders().add(order);

		 order.setCustomer(customer);

	     return ordersRepo.save(order);

	    }
	 
	 

}
