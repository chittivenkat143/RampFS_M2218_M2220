package com.hcl.employee.services.interfaces;

import java.util.List;

import com.hcl.employee.entity.Employee;

public interface IEmployeeService {
	public void addOrUpdateEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer employeeId);
	
	public void deleteEmployeeId(Integer employeeId);
	
	public List<Employee> getEmployees();
}
