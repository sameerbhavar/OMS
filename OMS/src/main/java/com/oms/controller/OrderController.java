package com.oms.controller;

import com.oms.model.Customer;
import com.oms.model.Orders;
import com.oms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;


    @PostMapping
    public ResponseEntity<Orders> createOrder(@RequestBody Orders order, @RequestBody Customer customer) {

        return new ResponseEntity<Orders>(orderService.createOrder(order,customer), HttpStatus.CREATED);

    }
}
