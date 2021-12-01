package com.companyportal.app.service;

import java.util.ArrayList;

import com.companyportal.app.entity.Employee;

public interface EmployeeService {

	public void saveEmployeeData(Employee employee);

	public ArrayList<Employee> getEmployeesData();

	public void deleteEmployeeData(Integer employeeId);

}
