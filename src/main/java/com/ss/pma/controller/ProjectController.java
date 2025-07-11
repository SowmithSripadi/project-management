package com.ss.pma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.pma.dao.EmployeeRepository;
import com.ss.pma.dao.ProjectRepository;
import com.ss.pma.entities.Employee;
import com.ss.pma.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	ProjectRepository proRepo;
	
	@Autowired
	EmployeeRepository empRepo;
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		Project aproject = new Project();
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees", employees);
		model.addAttribute("project", aproject);
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String saveProjectForm(Project project,@RequestParam List<Long> employees, Model model) {
		proRepo.save(project);
		return "redirect:/projects";
	}
	
	@GetMapping
	public String viewEmployees(Model model) {
		List<Project> projects=  proRepo.findAll();
		model.addAttribute("projects", projects);
		return "projects/projectsView";
	}
	
}	
