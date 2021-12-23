package com.hcl.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.employee.dto.BaseResponse;
import com.hcl.employee.dto.CustomerDto;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.services.EmployeeServiceImpl;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@GetMapping("/all")
	public BaseResponse getEmployees() {
		List<Employee> employees = employeeService.getEmployees();
		return new BaseResponse(HttpStatus.OK, employees);
	}
	
	@GetMapping("/{employeeId}")
	public BaseResponse getEmployee(@PathVariable("employeeId") Integer employeeId) {
		Employee employee = employeeService.getEmployeeById(employeeId);
		return new BaseResponse(HttpStatus.OK, employee);
	}
	
	@PostMapping("/saveOrUpdate")
	public BaseResponse saveOrUpdateEmployee(@RequestBody Employee employee) {
		employeeService.addOrUpdateEmployee(employee);
		return new BaseResponse(HttpStatus.CREATED, (employee!=null && employee.getEmployeeId()!=null) ? "Employee details updated successfully" : "Employee record created successfully");
	} 

	@DeleteMapping("/delete/{employeeId}")
	public BaseResponse deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deleteEmployeeId(employeeId);
		return new BaseResponse(HttpStatus.OK, "Employee record deleted successfully");
	}
	
	@GetMapping("/manage/employees")
	public BaseResponse getAllCustomer() {		
		CustomerDto customerDetails = employeeService.getCustomerDetails(10001l);
		return new BaseResponse(HttpStatus.OK, customerDetails);
	}
}
