package com.one.abc.customer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.abc.customer.entity.Customer;
import com.one.abc.customer.repo.CustomerRepo;
import com.one.abc.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;

	
	@Override
	public Customer saveCustomerInfo(Customer customer) {

		Customer returnCustomer = customerRepo.save(customer);

		return returnCustomer;
	}

	
	@Override
	public Customer getCustomerInfoByMob(String mob) {

		Customer response = customerRepo.findByMobileNumber(mob);

		return response;
	}

	 

}
