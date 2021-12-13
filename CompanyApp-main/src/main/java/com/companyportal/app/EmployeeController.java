package com.companyportal.app;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.companyportal.app.entity.Employee;
import com.companyportal.app.exception.EmployeeDetailsException;
import com.companyportal.app.service.EmployeeService;

@Controller
public class EmployeeController {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayRegistrationForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employeeform";
	}
	
	@RequestMapping(value = "/saveData", method = RequestMethod.POST)
	public String saveEmployeeData(@ModelAttribute("employee") Employee employee) {
		logger.info("Adding new Employee");
		employeeService.saveOrUpdateEmployee(employee);
		return "redirect:/employeelist";
	}
	
	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public String getEmployeesData(Model model) {
		logger.info("Retrive Employees");
		List<Employee> employeeList = employeeService.getEmployeesData();
		model.addAttribute("employeeList", employeeList);
		return "employeelist";
	}
	
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
	public String editEmployeeData(@RequestParam("employeeId") Integer employeeId, Model model) {
		logger.info("Updating Employee " + employeeId);
		Employee emp = employeeService.findEmployeeById(employeeId);
		model.addAttribute("employee", emp);
		return "editemployee";
	}
	
	@RequestMapping(value = "/employeeActivities", method = RequestMethod.GET)
	public String viewEmployeeActivities(@RequestParam("employeeId") Integer employeeId, Model model) {
		logger.info("View Employee Activities of" + employeeId);
		Employee emp = employeeService.findEmployeeById(employeeId);
		model.addAttribute("employee", emp);
		if(emp.getActivities().size() > 0) {
			model.addAttribute("activities", emp.getActivities());
		}else {
			model.addAttribute("info", "No Activities Found");
		}
		return "ViewEmpActivities";
	}
	
	@RequestMapping(value = "/deleteEmployee/{employeeId}", method = RequestMethod.GET)
	public String deleteEmployeeData(@PathVariable Integer employeeId) {
		logger.info("Deleting Employee " + employeeId);
		employeeService.deleteEmployeeData(employeeId);
		return "redirect:/employeelist";
	}
	
	@RequestMapping(value = "/filterEmployees", method = RequestMethod.GET)
	public @ResponseBody List<Employee> findEmployeesLike(@RequestParam("filterStr") String filterStr) {
		return employeeService.findEmployeeLike(filterStr);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchPage(Model model) {
		return "search";
	}
	
	@RequestMapping(value = "/searchEmployees", method = RequestMethod.POST)
	public String search(@RequestParam("searchText") String searchText,Model model){
		logger.info("Finding Employee contains " + searchText);
		List<Employee> allFound = employeeService.searchForEmployee(searchText);
		if(allFound.size() > 0) {
			model.addAttribute("employeeList",allFound);
		}else {
			model.addAttribute("info", "No Records found for " + searchText);
		}
		return "employeelist";
	}
	
	@ExceptionHandler({EmployeeDetailsException.class})
	public String handleException(HttpServletRequest httpServletRequest, Exception exp, Model model) {
		logger.error("Requested URL="+httpServletRequest.getRequestURL());
		logger.error("Exception Raised="+exp);
		EmployeeDetailsException exception = new EmployeeDetailsException("Phone Number must be 10 digit");
		model.addAttribute("exception", exception);
		return "EmployeeException";
	}
	
	@ExceptionHandler({org.hibernate.exception.ConstraintViolationException.class})
	public String handleHibernateException(HttpServletRequest httpServletRequest, Exception exp, Model model) {
		logger.error("Requested URL="+httpServletRequest.getRequestURL());
		logger.error("Exception Raised="+exp);
		EmployeeDetailsException exception = new EmployeeDetailsException("Email and Phone Number should be unique");
		model.addAttribute("employee", new Employee());
		model.addAttribute("exception", exception);
		return "employeeform";
	}
	
	@GetMapping(value = "/getEmpRq")
	@ResponseBody
	public Employee getEmployeeResponseBody() {
		return employeeService.findEmployeeById(2);
	}
}
