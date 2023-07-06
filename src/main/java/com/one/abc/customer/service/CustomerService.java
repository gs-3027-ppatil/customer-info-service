package com.one.abc.customer.service;

import com.one.abc.customer.entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomerInfo(Customer customer);

	public Customer getCustomer(Long customerId, String mobileNumber);

	public Customer updateCustomerInfo(Customer customer);

}
