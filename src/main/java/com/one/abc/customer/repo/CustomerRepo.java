package com.one.abc.customer.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.one.abc.customer.entity.Customer;

 

public interface CustomerRepo extends JpaRepository<Customer, Long> {

	Optional<Customer> findByMobileNumber(String mobileNumber);
}
