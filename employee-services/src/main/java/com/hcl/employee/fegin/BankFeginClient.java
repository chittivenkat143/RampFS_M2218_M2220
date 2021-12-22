package com.hcl.employee.fegin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.employee.dto.BaseResponse;
import com.hcl.employee.dto.CustomerRequestDTO;

//@FeignClient(name = "bank-service", url = "http://localhost:8081/bank")
public interface BankFeginClient {
	
	@PostMapping("/customers/saveorupdate")
	BaseResponse saveOrUpdateCustomer(@RequestBody CustomerRequestDTO customerDto);
	
	@GetMapping("/customer/{customerId}")
	BaseResponse getCustomerById(@PathVariable("customerId") Long customerId);
	
	@GetMapping("/mobile/{mobileNo}")
	BaseResponse getCustomersByCustomerMobile(@PathVariable String mobileNo);
	
	@GetMapping("/type/{customerType}")
	BaseResponse getCustomersByCustomerType(@PathVariable Integer customerType);
	
}
