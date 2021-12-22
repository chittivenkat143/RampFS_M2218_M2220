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
import org.springframework.web.reactive.function.client.WebClient;

import com.hcl.employee.dto.BaseResponse;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.services.EmployeeServiceImpl;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	private static final String GET_BANK_CUSTOMERS_BY_EMPID = "/customers/";

	@Autowired
	private EmployeeServiceImpl employeeService;
	
	@Autowired
	private WebClient client;
	
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
	
	@GetMapping("/customers/{employeeId}")
	public BaseResponse getAllCustomerByEmployeeId(@PathVariable("employeeId") Integer employeeId) {		
		Flux<BaseResponse> baseResponse = client.get().uri(GET_BANK_CUSTOMERS_BY_EMPID + "" + employeeId).retrieve().bodyToFlux(BaseResponse.class);
		
		return new BaseResponse(HttpStatus.OK, null);
	}
}
