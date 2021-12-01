package com.companyportal.app.dao.impl;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();

	@Override
	public void saveEmployeeData(Employee employee) {
		employeeList.add(employee);
	}

	@Override
	public ArrayList<Employee> getEmployeesData() {
		return employeeList;
	}

	@Override
	public void updateEmployeeData(Employee employee) {
		//employeeList.stream().filter(e -> e.getEmployeeId() == employee.getEmployeeId()).
		employeeList.stream().filter(e -> e.getEmployeeId() == employee.getEmployeeId())
				.forEach(e -> {
					e.setEmployeeId(employee.getEmployeeId());
					e.setName(employee.getName());
					e.setProject(employee.getProject());
					e.setMailId(employee.getMailId());
					e.setPhoneNo(employee.getPhoneNo());
				});
	}
	
	@Override
	public void deleteEmployeeData(Integer employeeId) {
		employeeList.removeIf(e -> e.getEmployeeId() == employeeId);						
	}

}
