package com.companyportal.app.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.entity.dto.EmployeeDTO;

@Component
public class MapperHelper {
	private static MapperHelper instance;
	private MapperHelper() {}
	public static MapperHelper getInstance() {
		if(instance==null) {
			return new MapperHelper();
		}
		return instance;
	}
	
	public Employee toEmployeeEntity(EmployeeDTO employeeDTO) {
		if(employeeDTO==null) {
			return null;
		}
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeDTO.getEmployeeId());
		employee.setName(employeeDTO.getName());
		employee.setCode(employeeDTO.getCode());
		employee.setProject(employeeDTO.getProject());
		employee.setMailId(employeeDTO.getMailId());
		employee.setPhoneNo(employeeDTO.getPhoneNo());
		return employee;
	}
	
	public EmployeeDTO toEmployeeDTO(Employee employee) {
		if(employee==null) {
			return null;
		}
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setEmployeeId(employee.getEmployeeId());
		employeeDTO.setName(employee.getName());
		employeeDTO.setCode(employee.getCode());
		employeeDTO.setProject(employee.getProject());
		employeeDTO.setMailId(employee.getMailId());
		employeeDTO.setPhoneNo(employee.getPhoneNo());
		return employeeDTO;
	}
	
	
	public List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees){
		return employees.stream().map(emp -> toEmployeeDTO(emp))
				.collect(Collectors.toList());
	}

}
