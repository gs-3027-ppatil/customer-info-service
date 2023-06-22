package com.one.abc.customer.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.abc.customer.entity.Customer;

 

public interface CustomerRepo extends JpaRepository<Customer, Long> {
	
	
	public Customer findByMobileNumber(String bookId);
	

}
