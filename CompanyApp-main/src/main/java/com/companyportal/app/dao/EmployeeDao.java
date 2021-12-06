package com.companyportal.app.dao;

import java.util.ArrayList;
import java.util.List;

import com.companyportal.app.entity.Employee;

public interface EmployeeDao {

	void saveEmployeeData(Employee employee);

	List<Employee> getEmployeesData();

	void updateEmployeeData(Employee employee);
	
	void deleteEmployeeData(Integer employeeId);
	
	List<Employee> findEmployeeLike(String likeStr);

	List<Employee> searchEmployeeData(String searchText);
}
