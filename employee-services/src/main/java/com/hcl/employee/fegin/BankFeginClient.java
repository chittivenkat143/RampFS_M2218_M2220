package com.hcl.employee.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.employee.dto.BaseResponse;
import com.hcl.employee.dto.CustomerRequestDTO;
import com.hcl.employee.utils.AppUtils;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@FeignClient(name = "bank-service", url = "http://localhost:8080/bank" /*Direct Service Hit*/)
public interface BankFeginClient {
	
	static final String CB_BANK_SERVICE = "CB-BANK-SERVICE";
	
	@CircuitBreaker(name = CB_BANK_SERVICE, fallbackMethod = "fallbackBaseResponse")
	@PostMapping("/customers/saveorupdate")
	BaseResponse saveOrUpdateCustomer(@RequestBody CustomerRequestDTO customerDto);
	
	@CircuitBreaker(name = CB_BANK_SERVICE, fallbackMethod = "fallbackBaseResponse")
	@GetMapping("/customers/customer/{customerId}")
	BaseResponse getCustomerById(@PathVariable("customerId") Long customerId);
	
	@CircuitBreaker(name = CB_BANK_SERVICE, fallbackMethod = "fallbackBaseResponse")
	@GetMapping("/customers/mobile/{mobileNo}")
	BaseResponse getCustomersByCustomerMobile(@PathVariable String mobileNo);
	
	@CircuitBreaker(name = CB_BANK_SERVICE, fallbackMethod = "fallbackBaseResponse")
	@GetMapping("/customers/type/{customerType}")
	BaseResponse getCustomersByCustomerType(@PathVariable Integer customerType);
	
	default BaseResponse fallbackBaseResponse() {
		return new BaseResponse(HttpStatus.NOT_FOUND, AppUtils.getInstance() + "\t| Service not found ! Please try again");
	}
	
	default BaseResponse fallbackBaseResponse(Throwable throwable) {
		return new BaseResponse(HttpStatus.NOT_FOUND, AppUtils.getInstance() + "\t| Service not found ! Please try again" + "\t| " + 
				throwable.getMessage());
	}
}
