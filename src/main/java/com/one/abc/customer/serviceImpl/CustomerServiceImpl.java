package com.one.abc.customer.serviceImpl;

import java.util.Optional;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.one.abc.customer.entity.Customer;
import com.one.abc.customer.exception.CustomException;
import com.one.abc.customer.repo.CustomerRepo;
import com.one.abc.customer.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo customerRepo;
	
	@Override
	public Customer saveCustomerInfo(Customer customer) {
		try {
			Customer returnCustomer = customerRepo.save(customer);
			return returnCustomer;
		} catch (DataIntegrityViolationException e) {
			e.printStackTrace();
			throw new CustomException(1102, "Mobile number already present");
		}
	}

	@Override
	public Customer getCustomer(Long customerId, String mobileNumber) {
			if (customerId == null && Strings.isBlank(mobileNumber)) {
				throw new CustomException(1101, "Please provide customerId or Mobile number");
			} else if (customerId != null) {
				Optional<Customer> customer = customerRepo.findById(customerId);
				return getCustomerFromDb(customer);
			} else if (!Strings.isBlank(mobileNumber)) {
				Optional<Customer> customer = customerRepo.findByMobileNumber(mobileNumber);
				return getCustomerFromDb(customer);
			}
		return null;
	}

	private Customer getCustomerFromDb(Optional<Customer> customer) {
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new CustomException(1100, "Customer does not exist");
		}
	}
}
