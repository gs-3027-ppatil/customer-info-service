package com.one.abc.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.one.abc.customer.entity.Customer;
import com.one.abc.customer.request.CustomerRequest;
import com.one.abc.customer.service.CustomerService;

@RestController
@RequestMapping("/oneabc")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@PostMapping("/customer")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		Customer response = customerService.saveCustomerInfo(customer);
		return new ResponseEntity<Customer>(response, HttpStatus.CREATED);

	}

	@GetMapping("/customer")
	public ResponseEntity<Customer> getCustomer(@RequestBody CustomerRequest CustomerRequest) {

		Customer response = null;
		String mob = CustomerRequest.getMobileNo();
		String customerId = CustomerRequest.getCustomerId();

		if (mob != null) {

			response = customerService.getCustomerInfoByMob(mob);

		}

		// Customer response = customerService.saveCustomerInfo(customer);
		return new ResponseEntity<Customer>(response, HttpStatus.CREATED);

	}

}
