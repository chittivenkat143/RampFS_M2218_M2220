package com.companyportal.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		logger.info(getClass() +":" + "Saving Or Updating the employee " + employee.toString());
		employeeDao.saveOrUpdateEmployee(employee);
	}

	@Override
	public List<Employee> getEmployeesData() {
		logger.info(getClass() +":" + "Fecthing employees ");
		return employeeDao.getEmployeesData();
	}
	
	@Override
	public Employee findEmployeeById(Integer employeeId) {	
		logger.info(getClass() +":" + "Finding employee based on Id:" + employeeId);
		return employeeDao.getEmployeeById(employeeId);
	}

	@Override
	public void deleteEmployeeData(Integer employeeId) {
		logger.info(getClass() +":" + "Deleting employee based on Id:" + employeeId);
		employeeDao.deleteEmployeeData(employeeId);
	}

	@Override
	public List<Employee> findEmployeeLike(String likeStr) {
		logger.info(getClass() +":" + "Fetching employees contains: " + likeStr);
		return employeeDao.findEmployeeLike(likeStr);
	}

	@Override
	public List<Employee> searchForEmployee(String searchText) {
		logger.info(getClass() +":" + "Fetching employees contains: " + searchText);
		return employeeDao.searchEmployeeData(searchText);
	}

}
