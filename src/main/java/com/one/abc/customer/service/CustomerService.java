package com.one.abc.customer.service;

import com.one.abc.customer.entity.Customer;

public interface CustomerService {
	
	public Customer saveCustomerInfo(Customer customer);
	
	public Customer getCustomerInfoByMob(String mob);

}
