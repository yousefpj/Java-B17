package com.yousef.controller;


import java.lang.reflect.Method;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yousef.dao.EmployeeDAO;
import com.yousef.dao.EmployeeDAOImpl;
import com.yousef.model.Employee;

@Controller
public class Employee_Controller 
{
	@Autowired
	EmployeeDAO dao1 = new EmployeeDAOImpl();
	
	
	@RequestMapping("/listEmployees" )
	public String listEmployees(Model model)
	{
		List<Employee> list = dao1.listEmployees();
		model.addAttribute("employeeList", list);
		return "listEmployees";
	}
	
	@RequestMapping("/addEmployeeForm")
	public String addEmployeeForm(Model model)
	{
		model.addAttribute("command", new Employee());
		return "addEmployeeForm";
	}
	
	@RequestMapping(value = "/addEmployee" , method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("emp") Employee emp)
	{
		dao1.addEmployee(emp);
		return "redirect:/listEmployees";
	}
	
	@RequestMapping(value = "/deleteEmployee/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable("id") int id)
	{
		dao1.deleteEmployee(id);
		return "redirect:/listEmployees"; 
	}
	
	@RequestMapping(value = "/editEmployeeForm/{id}" , method = RequestMethod.GET)
	public String editEmployeeForm(@PathVariable("id") int id , Model m)
	{
		Employee employee = dao1.getEmployee(id);
		m.addAttribute("command" , employee);
		return "editEmployee";
	}
	
	@RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
	public String editEmployee(@ModelAttribute("emp") Employee emp) {
		dao1.editEmployee(emp);
		return "redirect:/listEmployees"; 
	}
}
