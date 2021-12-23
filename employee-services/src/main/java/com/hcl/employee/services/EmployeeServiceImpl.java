package com.hcl.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.dto.AccountDto;
import com.hcl.employee.dto.AccountRequestDTO;
import com.hcl.employee.dto.BaseResponse;
import com.hcl.employee.dto.CustomerDto;
import com.hcl.employee.dto.CustomerRequestDTO;
import com.hcl.employee.entity.Activity;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.exception.EmployeeNotFoundException;
import com.hcl.employee.fegin.ActivityFeginClient;
import com.hcl.employee.fegin.BankFeginClient;
import com.hcl.employee.repo.EmployeeRespository;
import com.hcl.employee.services.interfaces.IEmployeeService;

import io.vavr.control.Option;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRespository respository;
	
	@Autowired
	private ActivityFeginClient employeeFegin;
	
	@Autowired
	private BankFeginClient bankFeginClient;

	@Override
	public void addOrUpdateEmployee(Employee employee) {
		respository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee = respository.findById(employeeId).get();
		if(employee!=null) {
			List<Activity> activities = employeeFegin.getActivitiesByCode(employee.getEmployeeId());
			employee.setActivities(activities);
			return employee;
		}else {
			throw new EmployeeNotFoundException("Employee not found by Id:" + employeeId);
		}
	}

	@Override
	public void deleteEmployeeId(Integer employeeId) {
		respository.deleteById(employeeId);
	}

	@Override
	public List<Employee> getEmployees() {
		return respository.findAll();
	}

	@Override
	public CustomerDto addOrUpdateCustomer(CustomerRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDto getCustomerDetails(Long customerId) {
		log.info("ESImpl: getCustomerDetails By Id:\t" + customerId);
		BaseResponse customerDetails = bankFeginClient.getCustomerById(customerId);		
		if(customerDetails!=null && customerDetails.getResponse() instanceof CustomerDto) {
			CustomerDto customer = (CustomerDto) customerDetails.getResponse();
			log.info("ESImpl: getCustomerDetails:\t" + customer.toString());
			return customer;
		}
		return null;
	}

	@Override
	public AccountDto addOrUpdateAccountDetails(AccountRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}
}
