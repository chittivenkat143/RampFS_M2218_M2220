package com.companyportal.app.service;

import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeService {

	public void saveOrUpdateEmployee(Employee employee);

	public List<Employee> getEmployeesData();

	public Employee findEmployeeById(Integer employeeId);
	
	public void deleteEmployeeData(Integer employeeId);
	
	List<Employee> findEmployeeLike(String likeStr);

	public List<Employee> searchForEmployee(String searchText);

}
