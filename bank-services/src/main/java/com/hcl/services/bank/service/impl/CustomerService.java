package com.hcl.services.bank.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.services.bank.domain.Customer;
import com.hcl.services.bank.domain.dto.CustomerDto;
import com.hcl.services.bank.domain.dto.projection.CustomerView;
import com.hcl.services.bank.domain.dto.projection.CustomerViewOpenProj;
import com.hcl.services.bank.exception.ResourceNotFoundException;
import com.hcl.services.bank.repo.CustomerRepository;
import com.hcl.services.bank.service.ICustomerService;

@Service
public class CustomerService implements ICustomerService {
	private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

	@Autowired
	private CustomerRepository repository;

	@Override
	public void saveOrUpdateCustomer(Customer customer) {
		logger.info("CS:saveOrUpdateCustomer");
		repository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long customerId) {
		logger.info("CS:getCustomerById:\t" + customerId);
		return repository.findById(customerId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer Not Found ID:" + customerId));
	}
	
	@Override
	public List<Customer> getCustomersByType(Integer customerType){
		logger.info("CS:getCustomersByType:\t" + customerType);
		return repository.findByCustomerType(customerType);
	}

	@Override
	public CustomerView getCustomerByCustomerMobile(String mobileNo) {
		logger.info("CS:getCustomerDtoByCustomerMobile:\t" + mobileNo);
		return repository.findCustomerByCustomerMobile(mobileNo);
	}
	
	@Override
	public CustomerViewOpenProj getCustomerByEmail(String email) {
		logger.info("CS:getCustomerByEmail:\t" + email);
		return repository.findByCustomerEmail(email);
	}
}
