package com.hcl.services.bank.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.services.bank.domain.Customer;
import com.hcl.services.bank.domain.dto.projection.CustomerView;
import com.hcl.services.bank.domain.dto.projection.CustomerViewOpenProj;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByCustomerType(Integer customerType);

	CustomerView findCustomerByCustomerMobile(String mobileNo);
	
	CustomerViewOpenProj findByCustomerEmail(String customerEmail);
}
