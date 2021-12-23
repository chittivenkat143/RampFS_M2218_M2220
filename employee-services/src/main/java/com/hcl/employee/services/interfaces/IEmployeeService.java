package com.hcl.employee.services.interfaces;

import java.util.List;

import com.hcl.employee.dto.AccountDto;
import com.hcl.employee.dto.AccountRequestDTO;
import com.hcl.employee.dto.CustomerDto;
import com.hcl.employee.dto.CustomerRequestDTO;
import com.hcl.employee.entity.Employee;

public interface IEmployeeService {
	public void addOrUpdateEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer employeeId);
	
	public void deleteEmployeeId(Integer employeeId);
	
	public List<Employee> getEmployees();
	
	
	/*
	 * Network Services for Bank-service
	 * Need to add ROLE (Employee) for Customer and Account Management 
	 */
	
	/**
	 * Add or Update Customer Details
	 * @param request
	 * @return
	 */
	public CustomerDto addOrUpdateCustomer(CustomerRequestDTO request);
	
	/**
	 * Get Customer Details By Customer Id
	 * @param customerId
	 * @return
	 */
	public CustomerDto getCustomerDetails(Long customerId);
	
	/**
	 * Add or Update Account Details 
	 * @param request
	 * @return
	 */
	public AccountDto addOrUpdateAccountDetails(AccountRequestDTO request);
}
