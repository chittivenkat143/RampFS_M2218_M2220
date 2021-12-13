package com.companyportal.app;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.entity.dto.EmployeeDTO;
import com.companyportal.app.exception.EmployeeDetailsException;
import com.companyportal.app.mappers.MapperHelper;
import com.companyportal.app.response.BaseResponse;
import com.companyportal.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
	
	private Logger logger = LoggerFactory.getLogger(EmployeeRestController.class);
	
	@Autowired
	private MapperHelper mapperH;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/")
	public BaseResponse getEmployees() {
		logger.info("REST: fetching all employees");
		List<EmployeeDTO> empDtos =  mapperH.toEmployeeDTOs(employeeService.getEmployeesData());
		return new BaseResponse(HttpStatus.CREATED.value(), empDtos);
	}
	
	@PostMapping(value="/addOrUpdateEmployee")
	public BaseResponse addorUpdateEmployee(@Valid @RequestBody EmployeeDTO employeedto) {
		Employee employee = mapperH.toEmployeeEntity(employeedto);
		if(employee!=null) {
			logger.info(employee.getEmployeeId()==null ? "REST: Adding Employee " + employee : "REST: Updating Employee " + employee);
			employeeService.saveOrUpdateEmployee(employee);
			return new BaseResponse(HttpStatus.CREATED.value(), employee);
		}else {
			throw new EmployeeDetailsException("Employee details not able to add or updated");
		}
	}
	
	@DeleteMapping(value="/deleteEmployee")
	public BaseResponse deleteEmployee(@RequestParam("employeeId") Integer employeeId) {
		logger.info("REST: Deleting Employee " + employeeId);
		employeeService.deleteEmployeeData(employeeId);
		return new BaseResponse(HttpStatus.OK.value(), "Employee Deleted Successfully");
	}
	
	@GetMapping(value="/{employeeId}")
	public BaseResponse getEmployeeById(@PathVariable("employeeId") Integer employeeId) {
		logger.info("REST: Find Employee " + employeeId);
		Employee employee = employeeService.findEmployeeById(employeeId);
		if(employee!=null) {
			return new BaseResponse(HttpStatus.OK.value(), mapperH.toEmployeeDTO(employee));
		}else {
			throw new EmployeeDetailsException("Employee not found");
		}
	}
	
}
