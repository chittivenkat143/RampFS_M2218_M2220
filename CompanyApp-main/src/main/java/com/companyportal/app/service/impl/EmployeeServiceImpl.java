package com.companyportal.app.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.companyportal.app.dao.EmployeeDao;
import com.companyportal.app.entity.Employee;
import com.companyportal.app.exception.EmployeeDetailsException;
import com.companyportal.app.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
	
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void saveEmployeeData(Employee employee) {
		if (employee.getPhoneNo().length() < 11 && employee.getPhoneNo().length() > 9) {
			if (employee.getEmployeeId() == null) {
				employeeDao.saveEmployeeData(employee);
			} else {
				employeeDao.updateEmployeeData(employee);
			}
		} else {
			throw new EmployeeDetailsException("Please check mobile Number");
		}
	}

	@Override
	public List<Employee> getEmployeesData() {
		return employeeDao.getEmployeesData();
	}
	
	@Override
	public Employee findEmployeeById(Integer employeeId) {
		return getEmployeesData()
				.stream()
				.filter(e -> e.getEmployeeId() == employeeId)
				.findAny()
				.get();
	}

	@Override
	public void deleteEmployeeData(Integer employeeId) {
		employeeDao.deleteEmployeeData(employeeId);
	}

	@Override
	public List<Employee> findEmployeeLike(String likeStr) {
		return employeeDao.findEmployeeLike(likeStr);
	}

	@Override
	public List<Employee> searchForEmployee(String searchText) {
		return employeeDao.searchEmployeeData(searchText);
	}

}
