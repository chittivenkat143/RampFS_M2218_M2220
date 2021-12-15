package com.hcl.services.bank.service;

import java.util.List;

import com.hcl.services.bank.domain.Customer;
import com.hcl.services.bank.domain.dto.CustomerDto;
import com.hcl.services.bank.domain.dto.projection.CustomerView;
import com.hcl.services.bank.domain.dto.projection.CustomerViewOpenProj;

public interface ICustomerService {
	public void saveOrUpdateCustomer(Customer customer);

	public Customer getCustomerById(Long customerId);
	
	public List<Customer> getCustomersByType(Integer customerType);

	public CustomerView getCustomerByCustomerMobile(String mobileNo);
	
	public CustomerViewOpenProj getCustomerByEmail(String email);
}
