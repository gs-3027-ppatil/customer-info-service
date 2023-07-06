package com.one.abc.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.one.abc.customer.entity.Customer;
import com.one.abc.customer.service.CustomerService;

@RestController
@RequestMapping("/oneabc/adityabirla/api/v1/customer/info")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		Customer response = customerService.saveCustomerInfo(customer);
		return new ResponseEntity<Customer>(response, HttpStatus.CREATED);

	}
	

	@GetMapping("/customer")
	public ResponseEntity<Customer> getCustomer(@RequestParam(name = "customerId", required = false) Long customerId,
			@RequestParam(name = "mobileNumber") String mobileNumber) {
		Customer customer = customerService.getCustomer(customerId, mobileNumber);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}
	
	@PutMapping("/customer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {

		Customer response = customerService.updateCustomerInfo(customer);
		return new ResponseEntity<Customer>(response, HttpStatus.CREATED);

	}

}
