package com.companyportal.app;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayRegistrationForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employeeform";
		//return new ModelAndView("employeeform", "employee", employee);
	}
	
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute Employee employee) {
		employeeService.saveEmployeeData(employee);
		return "redirect:/employeelist";
	}
	
	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String getEmployeesData(Model model) {
		ArrayList<Employee> employeeList = employeeService.getEmployeesData();
		model.addAttribute("employeeList", employeeList);
		return "employeelist";
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public String editEmployeeData(@RequestParam("employeeId") Integer employeeId, Model model) {
		Employee emp = employeeService.getEmployeesData()
				.stream()
				.filter(e -> e.getEmployeeId() == employeeId)
				.findAny()
				.get();
		model.addAttribute("employee", emp);
		return "editemployee";
	}
	
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
	public String deleteEmployeeData(@PathVariable Integer employeeId) {
		employeeService.deleteEmployeeData(employeeId);
		return "redirect:/employeelist";
	}
}
