package com.one.abc.customer.serviceImpl;

import java.util.Date;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
			customer.setCreatedDate(new Date());
			return customerRepo.save(customer);
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
		} else {
			if (!Strings.isBlank(mobileNumber) && isValidMobileNumber(mobileNumber)) {
				Optional<Customer> customer = customerRepo.findByMobileNumber(mobileNumber);
				return getCustomerFromDb(customer);
			} else {
				throw new CustomException(1101, "Please provide valid Mobile number");
			}
		}
	}

	private Customer getCustomerFromDb(Optional<Customer> customer) {
		if (customer.isPresent()) {
			return customer.get();
		} else {
			throw new CustomException(1100, "Customer does not exist");
		}
	}
	
	private boolean isValidMobileNumber(String mobileNumber) {
		if (Strings.isNotEmpty(mobileNumber)) {
			Pattern p = Pattern.compile("^\\d{10}$");
			Matcher m = p.matcher(mobileNumber);
			return m.matches();
		} else {
			return false;
		}
	}

	@Override
	public Customer updateCustomerInfo(Customer updateCustomerRequest) {
		try {
			String mobileNumber = updateCustomerRequest.getMobileNumber();
			if (!Strings.isBlank(mobileNumber) && isValidMobileNumber(mobileNumber)) {
				Optional<Customer> customer = customerRepo.findByMobileNumber(mobileNumber);
				Customer customerFromDB = getCustomerFromDb(customer);
				return updateDbCustomerInfo(updateCustomerRequest, customerFromDB);
			} else {
				throw new CustomException(1101, "Please provide valid Mobile number");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new CustomException(1103, e.getLocalizedMessage());
		}
	}

	private Customer updateDbCustomerInfo(Customer updateCustomerRequest, Customer customerFromDB) {
		if (Strings.isNotBlank(updateCustomerRequest.getFirstName())) {
			customerFromDB.setFirstName(updateCustomerRequest.getFirstName());
		}
		if (Strings.isNotBlank(updateCustomerRequest.getLastName())) {
			customerFromDB.setLastName(updateCustomerRequest.getLastName());
		}
		if (updateCustomerRequest.getDateOfBirth() != null) {
			customerFromDB.setDateOfBirth(updateCustomerRequest.getDateOfBirth());
		}
		if (Strings.isNotBlank(updateCustomerRequest.getEmail())) {
			customerFromDB.setEmail(updateCustomerRequest.getEmail());
		}
		if (Strings.isNotBlank(updateCustomerRequest.getModifiedBy())) {
			customerFromDB.setModifiedBy(updateCustomerRequest.getModifiedBy());
		}
		if (updateCustomerRequest.getmodifiedDate() != null) {
			customerFromDB.setmodifiedDate(new Date());
		}
		return customerRepo.save(customerFromDB);
	}
}
