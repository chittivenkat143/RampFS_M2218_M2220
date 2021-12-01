package com.companyportal.app.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private static int count=0;
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public void saveEmployeeData(Employee employee) {
		if(employee.getEmployeeId()==null) {
			employee.setEmployeeId(count++);
			employeeDao.saveEmployeeData(employee);
		}else {
			employeeDao.updateEmployeeData(employee);
		}
		
	}

	@Override
	public ArrayList<Employee> getEmployeesData() {
		return employeeDao.getEmployeesData();
	}
	
	@Override
	public void deleteEmployeeData(Integer employeeId) {
		employeeDao.deleteEmployeeData(employeeId);
	}

}
