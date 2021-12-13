package com.hcl.employee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.employee.entity.Activity;
import com.hcl.employee.entity.Employee;
import com.hcl.employee.exception.EmployeeNotFoundException;
import com.hcl.employee.fegin.EmployeeFeginClient;
import com.hcl.employee.repo.EmployeeRespository;
import com.hcl.employee.services.interfaces.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRespository respository;
	
	@Autowired
	private EmployeeFeginClient employeeFegin;

	@Override
	public void addOrUpdateEmployee(Employee employee) {
		respository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Integer employeeId) {
		Employee employee = respository.findById(employeeId).get();
		if(employee!=null) {
			List<Activity> activities = employeeFegin.getActivitiesByCode(employee.getEmployeeId());
			employee.setActivities(activities);
			return employee;
		}else {
			throw new EmployeeNotFoundException("Employee not found by Id:" + employeeId);
		}
	}

	@Override
	public void deleteEmployeeId(Integer employeeId) {
		respository.deleteById(employeeId);
	}

	@Override
	public List<Employee> getEmployees() {
		return respository.findAll();
	}
}
