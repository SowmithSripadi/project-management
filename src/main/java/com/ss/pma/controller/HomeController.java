package com.ss.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.pma.dao.EmployeeRepository;
import com.ss.pma.dao.ProjectRepository;
import com.ss.pma.entities.Employee;
import com.ss.pma.entities.Project;

@Controller

public class HomeController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/")
	public String displayHome(Model model) {
		List<Project> projects =  proRepo.findAll();
		List<Employee> employees=  empRepo.findAll();
		model.addAttribute("projects", projects);
		model.addAttribute("employees", employees);
		return "main/home";
	}
}
