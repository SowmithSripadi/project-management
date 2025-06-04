package com.ss.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ss.pma.dao.EmployeeRepository;
import com.ss.pma.dao.ProjectRepository;
import com.ss.pma.entities.Employee;
import com.ss.pma.entities.Project;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository empRepo;
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		Employee aemployee = new Employee();
		model.addAttribute("employee", aemployee);
		return "employees/new-employee";
	}
	
	@PostMapping("/save")
	public String saveEmployeeForm(Employee employee, Model model) {
		empRepo.save(employee);
		return "redirect:/employees";
	}
	
	@GetMapping
	public String viewEmployees(Model model) {
		List<Employee> employees =  empRepo.findAll();
		model.addAttribute("employees", employees);
		return "employees/employeesView";
	}
	
}
